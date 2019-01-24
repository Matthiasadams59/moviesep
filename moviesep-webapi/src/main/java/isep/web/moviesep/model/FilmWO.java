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
	protected String					originalLanguage;
	protected String 					rating;
	protected Date						releaseYear;
	protected String					specialFeatures;
	protected String					title;
	protected List<Actor>				actors;
	protected List<User>				users;
	


	public FilmWO()
	{
		super();
	}

	public FilmWO(int filmId, String category, String description, String language, int length, String originalLanguage, String rating, Date releaseYear, String specialFeatures, String title, List<Actor> actors, List<User> users)
	{
		super();
		this.filmId = filmId;
		this.category = category;
		this.description = description;
		this.language = language;
		this.length = length;
		this.originalLanguage = originalLanguage;
		this.rating = rating;
		this.releaseYear = releaseYear;
		this.specialFeatures = specialFeatures;
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
		this.originalLanguage = film.getOriginalLanguage();
		this.rating = film.getRating();
		this.releaseYear = film.getReleaseYear();
		this.specialFeatures = film.getSpecialFeatures();
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



	public String getOriginalLanguage() {
		return originalLanguage;
	}



	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public Date getReleaseYear() {
		return releaseYear;
	}



	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}



	public String getSpecialFeatures() {
		return specialFeatures;
	}



	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
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
				+ language + ", length=" + length + ", originalLanguage=" + originalLanguage + ", rating=" + rating
				+ ", releaseYear=" + releaseYear + ", specialFeatures=" + specialFeatures + ", title=" + title
				+ ", actors=" + actors.toString() + ", users=" + users.toString() + "]";
	}
	
	
}
