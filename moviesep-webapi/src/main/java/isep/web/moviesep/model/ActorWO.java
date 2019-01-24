package isep.web.moviesep.model;

import java.util.List;

import isep.web.moviesep.jpa.entities.Actor;
import isep.web.moviesep.jpa.entities.Film;

public class ActorWO extends WebObject
{

	//private static final long	serialVersionUID	= -1377067679473844279L;

	protected int							actorId;
	protected String					lastName;
	protected String					firstName;
	protected String					gender;
	protected List<Film>				films;

	public ActorWO()
	{
		super();
	}

	public ActorWO(int actorId, String lastName, String firstName, String gender, List<Film> films)
	{
		super();
		this.actorId = actorId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.films = films;
	}

	public ActorWO(final Actor actor)
	{
		super();
		this.actorId = actor.getActorId();
		this.lastName = actor.getLastName();
		this.firstName = actor.getFirstName();
		this.gender = actor.getGender();
		this.films = actor.getFilms();
	}

	public String getFirstName()
	{
		return firstName;
	}

	public int getActorId()
	{
		return actorId;
	}

	public String getLastName()
	{
		return lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public List<Film> getFilms() {
		return this.films;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setActorId(int actorId)
	{
		this.actorId = actorId;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", lastName=" + lastName + ", firstName=" + firstName + ", gender="
				+ gender + ", films=" + films.toString() + "]";
	}
}
