package isep.web.moviesep.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Column(nullable=false, length=25)
	private String category;

	@Lob
	private String description;

	@Column(nullable=false, length=20)
	private String language;

	private int length;

	@Column(name="original_language", length=20)
	private String originalLanguage;

	@Column(length=20)
	private String rating;

	@Temporal(TemporalType.DATE)
	@Column(name="release_year")
	private Date releaseYear;

	@Column(name="special_features", length=255)
	private String specialFeatures;

	@Column(nullable=false, length=255)
	private String title;

	//bi-directional many-to-many association to Actor
	@ManyToMany
	@JoinTable(
		name="film_actor"
		, joinColumns={
			@JoinColumn(name="film_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="actor_id", nullable=false)
			}
		)
	private List<Actor> actors;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="films")
	private List<User> users;

	public Film() {
	}

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getOriginalLanguage() {
		return this.originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Actor> getActors() {
		return this.actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}