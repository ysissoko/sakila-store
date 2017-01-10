package isep.web.sakila.webapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import isep.web.sakila.webapi.model.CityWO;
import isep.web.sakila.webapi.service.CityService;

@RestController
public class CityRestController {
	@Autowired
	CityService cityService;
	private static final Log	log	= LogFactory.getLog(CityRestController.class);

	@RequestMapping(value = "/city/", method = RequestMethod.GET)
	public ResponseEntity<List<CityWO>> listAllCities()
	{
		List<CityWO> cities = cityService.findAllCities();
		if (cities.isEmpty())
		{
			return new ResponseEntity<List<CityWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CityWO>>(cities, HttpStatus.OK);
	}

	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityWO> getCity(@PathVariable("id") int id)
	{
		System.out.println("Fetching city with id " + id);
		CityWO cityWO = cityService.findById(id);
		if (cityWO == null)
		{
			System.out.println("city with id " + id + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CityWO>(cityWO, HttpStatus.OK);
	}

	// -------------------Create a category----------------------------------

	@RequestMapping(value = "/city/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCity(@RequestBody CityWO cityWO, UriComponentsBuilder ucBuilder)
	{
		System.out.println("Creating city " + cityWO.getCity());

		cityService.saveCity(cityWO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/city/{id}").buildAndExpand(cityWO.getCityId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/cityUpdate/", method = RequestMethod.POST)
	public ResponseEntity<CityWO> updateCity(@RequestBody CityWO cityWO, UriComponentsBuilder ucBuilder)
	{
		log.error(String.format("Updating city %s ", cityWO.getCityId()));
		CityWO currentCity = cityService.findById(cityWO.getCityId());

		if (currentCity == null)
		{
			System.out.println("city with id " + cityWO.getCityId() + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}

		currentCity.setCity(cityWO.getCity());
		cityService.updateCity(currentCity);

		return new ResponseEntity<CityWO>(currentCity, HttpStatus.OK);
	}

	@RequestMapping(value = "/cityDelete/{id}", method = RequestMethod.GET)
	public ResponseEntity<CityWO> deleteCity(@PathVariable("id") int id)
	{

		System.out.println("Fetching & Deleting city with id " + id);

		CityWO cityWO = cityService.findById(id);
		if (cityWO == null)
		{
			System.out.println("Unable to delete. city with id " + id + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}

		cityService.deleteCityById(id);
		return new ResponseEntity<CityWO>(HttpStatus.NO_CONTENT);
	}
}
