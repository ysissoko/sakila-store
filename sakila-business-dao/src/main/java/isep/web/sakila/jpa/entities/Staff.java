package isep.web.sakila.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@Table(name="staff")
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="staff_id", unique=true, nullable=false)
	private byte staffId;

	@Column(nullable=false)
	private byte active;

	@Column(length=50)
	private String email;

	@Column(name="first_name", nullable=false, length=45)
	private String firstName;

	@Column(name="last_name", nullable=false, length=45)
	private String lastName;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	@Column(length=40)
	private String password;

	@Lob
	private byte[] picture;

	@Column(nullable=false, length=16)
	private String username;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="staff")
	@JsonIgnore
	private List<Payment> payments;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="staff")
	@JsonIgnore
	private List<Rental> rentals;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	@JsonIgnore
	private Address address;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="store_id", nullable=false)
	private Store store;

	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="staff")
	@JsonIgnore
	private List<Store> stores;

	public Staff() {
	}

	public byte getStaffId() {
		return this.staffId;
	}

	public void setStaffId(byte staffId) {
		this.staffId = staffId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setStaff(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setStaff(null);

		return payment;
	}

	public List<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public Rental addRental(Rental rental) {
		getRentals().add(rental);
		rental.setStaff(this);

		return rental;
	}

	public Rental removeRental(Rental rental) {
		getRentals().remove(rental);
		rental.setStaff(null);

		return rental;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Store> getStores() {
		return this.stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setStaff(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setStaff(null);

		return store;
	}

}