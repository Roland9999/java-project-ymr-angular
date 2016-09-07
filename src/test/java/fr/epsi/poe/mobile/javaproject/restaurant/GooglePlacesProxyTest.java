package fr.epsi.poe.mobile.javaproject.restaurant;

import fr.epsi.poe.mobile.javaproject.restaurant.services.GooglePlacesProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Yannis Mazzer <yannis@ioweb.fr>
 * @created_on 13/07/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestaurantChooserApiApplication.class)
@TestPropertySource(locations="classpath:application.properties")
public class GooglePlacesProxyTest {

    private static Logger logger = LoggerFactory.getLogger(GooglePlacesProxyTest.class);

    @Autowired
    private GooglePlacesProxy googlePlacesProxy;

    @Test
    public void testFindRestaurantNearBy() throws Exception {
        googlePlacesProxy.findRestaurantNearBy()
                .stream()
                .forEach(placesSearchResult -> logger.info(placesSearchResult.name + ": " + placesSearchResult.vicinity));
    }
}