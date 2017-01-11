package isep.web.sakila.webapi.model;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Payment;
import isep.web.sakila.jpa.entities.Rental;
import isep.web.sakila.jpa.entities.Store;

public class CustomerWO extends WebObject{

	private static final long serialVersionUID = -3940626561941477764L;
	private int customerId;
	private byte active;
	private Date createDate;
	private String email;
	private String firstName;
	private String lastName;
	private Timestamp lastUpdate;
	private Address address;
	private Store store;
	private List<Payment> payments;
	private List<Rental> rentals;
	
	public CustomerWO()
	{
		super();
	}

	public CustomerWO(byte customerId, byte active, Date createDate, String email, String firstName, String lastName, Timestamp lastUpdate, Address address, Store store, List<Payment> payments, List<Rental> rentals)
	{	
		super();
		this.customerId = customerId;
		this.active = active;
		this.createDate = createDate;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
		this.address = address;
		this.store = store;
		this.payments = payments;
		this.rentals = rentals;
	}

	public CustomerWO(final Customer customer)
	{
		super();
		this.customerId = customer.getCustomerId();
		this.active = customer.getActive();
		this.createDate = customer.getCreateDate();
		this.email = customer.getEmail();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.lastUpdate = customer.getLastUpdate();
		this.address = customer.getAddress();
		this.store = customer.getStore();
		this.payments = customer.getPayments();
		this.rentals = customer.getRentals();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}
	
	
	
}
