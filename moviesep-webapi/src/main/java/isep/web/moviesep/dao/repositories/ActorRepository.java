package isep.web.moviesep.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import isep.web.moviesep.jpa.entities.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer>
{
}
