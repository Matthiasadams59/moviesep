package isep.web.moviesep.dao.business;

import java.util.List;

import isep.web.moviesep.jpa.entities.Actor;

public interface IBusiness
{
	public List<Actor> getAllActors();

	public Actor getByID(int actorId);

}
