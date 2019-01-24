package isep.web.moviesep.service;

import java.sql.Timestamp;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.moviesep.dao.repositories.FilmRepository;
import isep.web.moviesep.jpa.entities.Film;
import isep.web.moviesep.model.FilmWO;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmRepository filmRepository;

	private static final Log log = LogFactory.getLog(FilmServiceImpl.class);

	@Override
	public List<FilmWO> findAllFilms() {
		List<FilmWO> films = new LinkedList<FilmWO>();

		for (Film film : filmRepository.findAll()) {
			films.add(new FilmWO(film));
			log.debug("Adding " + film);
		}

		return films;
	}

	@Override
	public FilmWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Film film = filmRepository.findById(id).get();

		if (film != null) {
			return new FilmWO(film);
		}
		return null;
	}

	@Override
	public void saveFilm(FilmWO filmWO) {
		Film film = new Film();
		film.setCategory(filmWO.getCategory());
		film.setDescription(filmWO.getDescription());
		film.setLanguage(filmWO.getLanguage());
		film.setLength(filmWO.getLength());
		film.setOriginalLanguage(filmWO.getOriginalLanguage());
		film.setRating(filmWO.getRating());
		film.setReleaseYear(filmWO.getReleaseYear());
		film.setSpecialFeatures(filmWO.getSpecialFeatures());
		film.setTitle(filmWO.getTitle());
		film.setActors(filmWO.getActors());
		film.setUsers(filmWO.getUsers());
		filmRepository.save(film);
	}

	@Override
	public void updateFilm(FilmWO filmWO) {
		Film film2update = filmRepository.findById(filmWO.getFilmId()).get();
		film2update.setCategory(filmWO.getCategory());
		film2update.setDescription(filmWO.getDescription());
		film2update.setLanguage(filmWO.getLanguage());
		film2update.setLength(filmWO.getLength());
		film2update.setOriginalLanguage(filmWO.getOriginalLanguage());
		film2update.setRating(filmWO.getRating());
		film2update.setReleaseYear(filmWO.getReleaseYear());
		film2update.setSpecialFeatures(filmWO.getSpecialFeatures());
		film2update.setTitle(filmWO.getTitle());
		film2update.setActors(filmWO.getActors());
		film2update.setUsers(filmWO.getUsers());
		filmRepository.save(film2update);
	}

	@Override
	public void deleteFilmById(int id) {
		filmRepository.deleteById(id);
	}

}
