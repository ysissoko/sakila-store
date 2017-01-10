package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import isep.web.sakila.webapi.model.CityWO;
import isep.web.sakila.dao.repositories.CityRepository;
import isep.web.sakila.jpa.entities.City;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityRepository		cityRepository;
	private static final Log	log	= LogFactory.getLog(CityServiceImpl.class);

	@Override
	public CityWO findById(int id) {
		log.debug(String.format("Looking for city by Id %s", id));
		City city = cityRepository.findOne(id);

		if (city != null)
		{
			return new CityWO(city);
		}
		return null;
	}

	@Override
	public void saveCity(CityWO cityWO) {
		City city = new City();
		city.setCity(cityWO.getCity());
		//city.setAddresses(cityWO.getAddresses());
		city.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		cityRepository.save(city);	
	}

	@Override
	public void updateCity(CityWO cityWO) {
		City city2update = cityRepository.findOne(cityWO.getCityId());
		city2update.setCity(cityWO.getCity());
		//city2update.setAddresses(cityWO.getAddresses());
		city2update.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		cityRepository.save(city2update);
	}

	@Override
	public void deleteCityById(int id) {
		cityRepository.delete(id);
	}

	@Override
	public List<CityWO> findAllCities() {
		List<CityWO> cities = new LinkedList<CityWO>();

		for (City city : cityRepository.findAll())
		{
			cities.add(new CityWO(city));
			log.debug("Adding city " + city);
		}

		return cities;
	}

}
