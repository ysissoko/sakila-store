package isep.web.sakila.webapi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import isep.web.sakila.jpa.config.PersistenceConfig;
import isep.web.sakila.webapi.model.ActorWO;
import isep.web.sakila.webapi.service.ActorService;


@SpringApplicationConfiguration(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ActorTest {

	@Autowired
	private ActorService service;
	
	@Test
	public void testFindById() {
		Assert.assertEquals("NICK", service.findById(2).getFirstName());
	}

	@Test
	public void testSaveActor() {
		ActorWO newWO = new ActorWO();
		newWO.setActorId(201);
		newWO.setFirstName("testFname");
		newWO.setLastName("testLname");
		service.saveActor(newWO);
		Assert.assertEquals("zpeng", service.findAllActors().indexOf(newWO)!=0);
	}

}