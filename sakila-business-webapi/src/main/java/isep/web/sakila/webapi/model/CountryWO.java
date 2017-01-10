package isep.web.sakila.webapi.model;

import java.sql.Timestamp;
import java.util.List;
import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.jpa.entities.Country;

public class CountryWO extends WebObject {

	private static final long serialVersionUID = 1L;
	private int countryId;
	private String country;
	private Timestamp lastUpdate;
	private List<City> cities;
	
	public CountryWO()
	{
		super();
	}

	public CountryWO(int countryId, String country, Timestamp lastUpdate, List<City> cities)
	{
		super();
		this.countryId = countryId;
		this.country = country;
		this.lastUpdate = lastUpdate;
		this.cities = cities;
	}

	public CountryWO(final Country country)
	{
		super();
		this.countryId = country.getCountryId();
		this.country = country.getCountry();
		this.lastUpdate = country.getLastUpdate();
		this.cities = country.getCities();
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
}
