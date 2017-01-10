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
import isep.web.sakila.webapi.model.CountryWO;
import isep.web.sakila.webapi.service.CountryService;

@RestController
public class CountryRestController {
	@Autowired
	CountryService countryService;
	private static final Log	log	= LogFactory.getLog(CountryRestController.class);

	@RequestMapping(value = "/country/", method = RequestMethod.GET)
	public ResponseEntity<List<CountryWO>> listAllCountries()
	{
		List<CountryWO> countries = countryService.findAllCountries();
		if (countries.isEmpty())
		{
			return new ResponseEntity<List<CountryWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CountryWO>>(countries, HttpStatus.OK);
	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CountryWO> getCountry(@PathVariable("id") int id)
	{
		log.info("Fetching country with id " + id);
		CountryWO countryWO = countryService.findById(id);
		if (countryWO == null)
		{
			System.out.println("country with id " + id + " not found");
			return new ResponseEntity<CountryWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CountryWO>(countryWO, HttpStatus.OK);
	}

	// -------------------Create a category----------------------------------

	@RequestMapping(value = "/country/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCountry(@RequestBody CountryWO countryWO, UriComponentsBuilder ucBuilder)
	{
		System.out.println("Creating country " + countryWO.getCountry());

		countryService.saveCountry(countryWO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/country/{id}").buildAndExpand(countryWO.getCountryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/countryUpdate/", method = RequestMethod.POST)
	public ResponseEntity<CountryWO> updateCountry(@RequestBody CountryWO countryWO, UriComponentsBuilder ucBuilder)
	{
		log.error(String.format("Updating country %s ", countryWO.getCountryId()));
		CountryWO currentCountry = countryService.findById(countryWO.getCountryId());

		if (currentCountry == null)
		{
			System.out.println("country with id " + countryWO.getCountryId() + " not found");
			return new ResponseEntity<CountryWO>(HttpStatus.NOT_FOUND);
		}

		currentCountry.setCountry(countryWO.getCountry());
		countryService.updateCountry(currentCountry);

		return new ResponseEntity<CountryWO>(currentCountry, HttpStatus.OK);
	}

	@RequestMapping(value = "/countryDelete/{id}", method = RequestMethod.GET)
	public ResponseEntity<CountryWO> deleteCountry(@PathVariable("id") int id)
	{

		System.out.println("Fetching & Deleting country with id " + id);

		CountryWO countryWO = countryService.findById(id);
		if (countryWO == null)
		{
			System.out.println("Unable to delete. country with id " + id + " not found");
			return new ResponseEntity<CountryWO>(HttpStatus.NOT_FOUND);
		}

		countryService.deleteCountryById(id);
		return new ResponseEntity<CountryWO>(HttpStatus.NO_CONTENT);
	}
}
