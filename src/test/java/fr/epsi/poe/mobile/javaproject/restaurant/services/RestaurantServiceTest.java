package fr.epsi.poe.mobile.javaproject.restaurant.services;

import fr.epsi.poe.mobile.javaproject.restaurant.RestaurantChooserApiApplication;
import fr.epsi.poe.mobile.javaproject.restaurant.models.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * @author Yannis Mazzer <yannis@ioweb.fr>
 * @created_on 19/07/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestaurantChooserApiApplication.class)
@TestPropertySource(locations="classpath:application.properties")
public class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void shouldReturnAnEmptyListOfRestaurants() throws Exception{
        List<Restaurant> restaurantsList = restaurantService.getRestaurantsFromGoogle(3.2,12.5);
        assertThat(restaurantsList).isEmpty();
    }

}