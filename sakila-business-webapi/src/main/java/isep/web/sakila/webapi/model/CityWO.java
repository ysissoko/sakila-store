package isep.web.sakila.webapi.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.City;

public class CityWO extends WebObject {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private int cityId;
	@JsonIgnore
	private String city;
	private Timestamp lastUpdate;
	@JsonIgnore
	private List<Address> addresses;
	
	public CityWO()
	{
		super();
	}

	public CityWO(int cityId, String city, Timestamp lastUpdate, List<Address> addresses)
	{
		super();
		this.cityId = cityId;
		this.city = city;
		this.lastUpdate = lastUpdate;
		this.addresses = addresses;
	}

	public CityWO(final City city)
	{
		super();
		this.cityId = city.getCityId();
		this.city = city.getCity();
		this.lastUpdate = city.getLastUpdate();
		this.addresses = city.getAddresses();
	}
	@JsonIgnore
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	@JsonIgnore
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@JsonIgnore
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@JsonIgnore
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}
