package isep.web.moviesep.model;

import java.util.Date;
import java.util.List;

import isep.web.moviesep.jpa.entities.Actor;
import isep.web.moviesep.jpa.entities.Film;
import isep.web.moviesep.jpa.entities.User;

public class FilmWO extends WebObject
{

	//private static final long	serialVersionUID	= -1377067679473844279L;

	protected int						filmId;
	protected String					category;
	protected String					description;
	protected String					language;
	protected int						length;
	protected String 					rating;
	protected int						releaseYear;
	protected String					title;
	protected List<Actor>				actors;
	protected List<User>				users;
	


	public FilmWO()
	{
		super();
	}

	public FilmWO(int filmId, String category, String description, String language, int length, String originalLanguage, String rating, int releaseYear, String specialFeatures, String title, List<Actor> actors, List<User> users)
	{
		super();
		this.filmId = filmId;
		this.category = category;
		this.description = description;
		this.language = language;
		this.length = length;
		this.rating = rating;
		this.releaseYear = releaseYear;
		this.title = title;
		this.actors = actors;
		this.users = users;
	}

	public FilmWO(final Film film)
	{
		super();
		this.filmId = film.getFilmId();
		this.category = film.getCategory();
		this.description = film.getDescription();
		this.language = film.getLanguage();
		this.length = film.getLength();
		this.rating = film.getRating();
		this.releaseYear = film.getReleaseYear();
		this.title = film.getTitle();
		this.actors = film.getActors();
		this.users = film.getUsers();
	}

	public int getFilmId() {
		return filmId;
	}



	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}


	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public int getReleaseYear() {
		return releaseYear;
	}



	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public List<Actor> getActors() {
		return actors;
	}



	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	@Override
	public String toString() {
		return "FilmWO [filmId=" + filmId + ", category=" + category + ", description=" + description + ", language="
				+ language + ", length=" + length + ", rating=" + rating
				+ ", releaseYear=" + releaseYear + ", title=" + title
				+ ", actors=" + actors.toString() + ", users=" + users.toString() + "]";
	}
	
	
}
