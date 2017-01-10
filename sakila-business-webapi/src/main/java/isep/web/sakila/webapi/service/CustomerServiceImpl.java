package isep.web.sakila.webapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.webapi.model.CustomerWO;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository		customerRepository;
	
	@Override
	public CustomerWO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCustomer(CustomerWO customerWO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(CustomerWO customerWO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerWO> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
