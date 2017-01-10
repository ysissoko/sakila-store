package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import isep.web.sakila.dao.repositories.FilmRepository;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.webapi.model.FilmWO;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService
{
	@Autowired
	private FilmRepository		filmRepository;
	
	private static final Log	log	= LogFactory.getLog(FilmServiceImpl.class);
	
	@Override
	public List<FilmWO> findAllFilms()
	{
		List<FilmWO> films = new LinkedList<FilmWO>();

		for (Film film : filmRepository.findAll())
		{
			films.add(new FilmWO(film));
			log.debug("Adding " + film);
		}

		return films;
	}
	
	@Override
	public FilmWO findById(int id)
	{
		log.debug(String.format("Looking for film by Id %s", id));
		Film film = filmRepository.findOne(id);

		if (film != null)
		{
			return new FilmWO(film);
		}
		return null;
	}
	
	@Override
	public void saveFilm(FilmWO filmWO)
	{
		Film film = new Film();
		film.setTitle(filmWO.getTitle());
		film.setDescription(filmWO.getDescription());
		film.setReleaseYear(filmWO.getReleaseYear());
		film.setLanguage1(filmWO.getLanguage());
		film.setLanguage2(filmWO.getOriginalLanguage());
		film.setRentalDuration(filmWO.getRentalDuration());
		film.setRentalRate(filmWO.getRentalRate());
		film.setLength(filmWO.getLength());
		film.setReplacementCost(filmWO.getReplacementCost());
		film.setRating(filmWO.getRating());
		film.setSpecialFeatures(filmWO.getSpecialFeatures());
		film.setFilmActors(filmWO.getActors());
		film.setFilmCategories(filmWO.getCategories());
		film.setInventories(filmWO.getInventories());
		film.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		filmRepository.save(film);
	}
	
	@Override
	public void updateFilm(FilmWO filmWO)
	{
		Film film2update = filmRepository.findOne(filmWO.getFilmId());
		film2update.setTitle(filmWO.getTitle());
		film2update.setDescription(filmWO.getDescription());
		film2update.setReleaseYear(filmWO.getReleaseYear());
		film2update.setLanguage1(filmWO.getLanguage());
		film2update.setLanguage2(filmWO.getOriginalLanguage());
		film2update.setRentalDuration(filmWO.getRentalDuration());
		film2update.setRentalRate(filmWO.getRentalRate());
		film2update.setLength(filmWO.getLength());
		film2update.setReplacementCost(filmWO.getReplacementCost());
		film2update.setRating(filmWO.getRating());
		film2update.setSpecialFeatures(filmWO.getSpecialFeatures());
		film2update.setFilmActors(filmWO.getActors());
		film2update.setFilmCategories(filmWO.getCategories());
		film2update.setInventories(filmWO.getInventories());
		film2update.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		filmRepository.save(film2update);
	}

	@Override
	public void deleteFilmById(int id)
	{
		filmRepository.delete(id);
	}

}

