package isep.web.moviesep.model;

import java.util.Date;
import java.util.List;

import isep.web.moviesep.jpa.entities.Actor;
import isep.web.moviesep.jpa.entities.Film;
import isep.web.moviesep.jpa.entities.User;

public class UserWO {
	
	protected int						userId;
	protected String					firstName;
	protected String					lastName;
	protected String					mail;
	protected String					password;
	protected String 					username;
	protected List<Film>				films;

	public UserWO()
	{
		super();
	}
	
	public UserWO(int userId, String firstName, String lastName, String mail, String password, String username, List<Film> films) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.password = password;
		this.username = username;
		this.films = films;
	}
	
	public UserWO(final User user) {
		this.userId = user.getUserId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.mail = user.getMail();
		this.password = user.getPassword();
		this.username = user.getUsername();
		this.films = user.getFilms();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "UserWO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail
				+ ", password=" + password + ", username=" + username + ", films=" + films.toString() + "]";
	}
	
	


}
