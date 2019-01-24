package isep.web.moviesep.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import isep.web.moviesep.jpa.entities.Film;

public interface FilmRepository extends CrudRepository<Film, Integer>
{
}
