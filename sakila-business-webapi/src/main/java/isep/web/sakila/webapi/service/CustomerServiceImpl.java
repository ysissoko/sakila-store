package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.AddressRepository;
import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.dao.repositories.StoreRepository;
import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Store;
import isep.web.sakila.webapi.model.CustomerWO;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	// log
	private static final Log log = LogFactory.getLog(CustomerServiceImpl.class);

	// find all customers
	@Override
	public List<CustomerWO> findAllCustomers() {
		List<CustomerWO> customers = new LinkedList<CustomerWO>();

		for (Customer customer : customerRepository.findAll()) {
			customers.add(new CustomerWO(customer));
			log.debug("Adding " + customer);
		}

		return customers;
	}

	// find by id
	@Override
	public CustomerWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Customer customer = customerRepository.findOne(id);

		if (customer != null) {
			return new CustomerWO(customer);
		}
		return null;
	}

	// save customer
	@Override
	public void saveCustomer(CustomerWO customerWO) {
		Customer customer = new Customer();
		customer.setLastName(customerWO.getLastName());
		customer.setFirstName(customerWO.getFirstName());
		customer.setEmail(customerWO.getEmail());
		
		Address address = addressRepository.findOne(customerWO.getAddress().getAddressId());
		if(address != null){
			customer.setAddress(address);
		}
		
		Store store = storeRepository.findOne(customerWO.getStore().getStoreId());
		if(store != null){
			customer.setStore(store);
		}
		

		Date dateobj = new Date();
		customer.setCreateDate(dateobj);
		customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customerRepository.save(customer);
	}

	// update customer
	@Override
	public void updateCustomer(CustomerWO customerWO) {
		Customer customer2update = customerRepository.findOne(customerWO.getCustomerId());
		customer2update.setLastName(customerWO.getLastName());
		customer2update.setFirstName(customerWO.getFirstName());
		
		Address address = addressRepository.findOne(customerWO.getAddress().getAddressId());
		if(address != null){
			customer2update.setAddress(address);
		}
		
		Store store = storeRepository.findOne(customerWO.getStore().getStoreId());
		if(store != null){
			customer2update.setStore(store);
		}
		
		
		customer2update.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customerRepository.save(customer2update);
	}
	
	// delete customer
	@Override
	public void deleteCustomerById(int id) {
		customerRepository.delete(id);
	}
}
