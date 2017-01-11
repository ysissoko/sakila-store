package isep.web.sakila.webapi.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.jpa.entities.Country;

public class CountryWO extends WebObject {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private int countryId;
	@JsonIgnore
	private String country;
	@JsonIgnore
	private Timestamp lastUpdate;
	@JsonIgnore
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

	@JsonIgnore
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@JsonIgnore
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonIgnore
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@JsonIgnore
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
}
