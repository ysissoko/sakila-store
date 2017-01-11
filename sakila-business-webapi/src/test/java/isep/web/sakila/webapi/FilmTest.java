package isep.web.sakila.webapi;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import isep.web.sakila.jpa.config.PersistenceConfig;
import isep.web.sakila.webapi.service.FilmService;

@SpringApplicationConfiguration(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FilmTest {

	@Autowired
	private FilmService service;
	
	@Test
	public void testFindById() {
		Assert.assertEquals("AFFAIR PREJUDICE", service.findById(4).getTitle());
	}


}