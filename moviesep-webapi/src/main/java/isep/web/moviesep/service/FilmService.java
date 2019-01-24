package isep.web.moviesep.service;

import java.util.List;

import isep.web.moviesep.model.FilmWO;

public interface FilmService
{
	FilmWO findById(int id);

	void saveFilm(FilmWO userWO);

	void updateFilm(FilmWO userWO);

	void deleteFilmById(int id);

	List<FilmWO> findAllFilms();

}
