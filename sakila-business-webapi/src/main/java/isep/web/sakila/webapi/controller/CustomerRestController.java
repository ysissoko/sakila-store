package isep.web.sakila.webapi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import isep.web.sakila.webapi.service.CustomerService;

@RestController
public class CustomerRestController {
	@Autowired
	CustomerService customerService;
	private static final Log	log	= LogFactory.getLog(CustomerRestController.class);

}
