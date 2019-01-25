-- Moviesep Database
-- https://github.com/Matthiasadams59/moviesep

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS moviesep;
CREATE SCHEMA moviesep;
USE moviesep;

--
-- Table structure for table `user`
--

CREATE TABLE user (
  user_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `actor`
--

CREATE TABLE actor (
  actor_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  gender VARCHAR(20) NOT NULL,
  PRIMARY KEY (actor_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `film`
--

CREATE TABLE film (
  film_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT DEFAULT NULL,
  release_year YEAR DEFAULT NULL,
  language VARCHAR(20)  NOT NULL,
  category VARCHAR(25) NOT NULL,
  length SMALLINT UNSIGNED DEFAULT NULL,
  rating VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY  (film_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `film_actor`
--

CREATE TABLE film_actor (
  actor_id SMALLINT UNSIGNED NOT NULL,
  film_id SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY  (actor_id,film_id),
  CONSTRAINT fk_film_actor_actor FOREIGN KEY (actor_id) REFERENCES actor (actor_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_film_actor_film FOREIGN KEY (film_id) REFERENCES film (film_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_favorite_movies`
--

CREATE TABLE user_favorite_movies (
  user_id SMALLINT UNSIGNED NOT NULL,
  film_id SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY  (user_id,film_id),
  CONSTRAINT fk_user_favorites_user FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_user_favorites_film FOREIGN KEY (film_id) REFERENCES film (film_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table user
--

INSERT INTO user VALUES (1,'rippaulwalker','ff4life'),
(2,'thanosdu92','madarauchiwa');

--
-- Dumping data for table actor
--

INSERT INTO actor VALUES (1,'John','Travolta','male'),
(2,'Samuel L.','Jackson','male'),
(3,'Uma','Thurman','female'),
(4,'Alexandre','Rodrigues','male'),
(5,'Leandro','Firminio','male'),
(6,'Matheus','Nachtergaele','male'),
(7,'Pam','Grier','female'),
(8,'Robert','De Niro','male'),
(9,'Jodie','Foster','female');

--
-- Dumping data for table film
--

INSERT INTO film VALUES (1,'Pulp Fiction','The lives of two mob hitmen, a boxer, a gangster\'s wife, and a pair of diner bandits intertwine in four tales of violence and redemption.',1994, 'English', 'Crime', 154, 8.9),
(2,'City of God','In the slums of Rio, two kids\' paths diverge as one struggles to become a photographer and the other a kingpin.',2002, 'Spanish', 'Drama', 130, 8.6),
(3,'Jackie Brown','A middle-aged woman finds herself in the middle of a huge conflict that will either make her a profit or cost her life.',1997, 'English', 'Thriller', 154, 7.5),
(4,'Taxi Driver','A mentally unstable veteran works as a nighttime taxi driver in New York City, where the perceived decadence and sleaze fuels his urge for violent action by attempting to liberate a presidential campaign worker and an underage prostitute.',1976, 'English', 'Drama', 114, 8.3);

--
-- Dumping data for table film_actor
--

INSERT INTO film_actor VALUES (1,1),
(2,1),
(3,1),
(4,2),
(5,2),
(6,2),
(2,3),
(7,3),
(8,3),
(8,4),
(9,4);

--
-- Dumping data for table user_favorite_movies
--

INSERT INTO user_favorite_movies VALUES (1,1),
(1,2),
(2,3),
(2,4);

--

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


