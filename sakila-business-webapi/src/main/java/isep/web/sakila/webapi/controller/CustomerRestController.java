package isep.web.sakila.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

import isep.web.sakila.webapi.model.CustomerWO;
import isep.web.sakila.webapi.service.CustomerService;


@RestController
public class CustomerRestController {

	@Autowired
	CustomerService cutomerService;


	@RequestMapping(value = "/Customers/", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerWO>> listAllCustomers() {

		List<CustomerWO> customers = cutomerService.findAllCustomers();
		if (customers.isEmpty()) {
			return new ResponseEntity<List<CustomerWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CustomerWO>>(customers, HttpStatus.OK);
	}

	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@RequestMapping(value = "/createCustomer/", method = RequestMethod.POST)
	public ResponseEntity<String> createCustomer(@RequestBody CustomerWO customerWO, UriComponentsBuilder ucBuilder) {
		cutomerService.saveCustomer(customerWO);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customerWO.getCustomerId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@RequestMapping(value = "/updateCustomer/", method = RequestMethod.POST)
	public ResponseEntity<String> updateCustomer(@RequestBody CustomerWO customerWO, UriComponentsBuilder ucBuilder) {
		cutomerService.updateCustomer(customerWO);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customerWO.getCustomerId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}


}
