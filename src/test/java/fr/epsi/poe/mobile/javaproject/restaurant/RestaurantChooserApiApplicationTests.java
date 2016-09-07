package fr.epsi.poe.mobile.javaproject.restaurant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestaurantChooserApiApplication.class)
@WebAppConfiguration
@TestPropertySource(locations="classpath:application.properties")
public class RestaurantChooserApiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
