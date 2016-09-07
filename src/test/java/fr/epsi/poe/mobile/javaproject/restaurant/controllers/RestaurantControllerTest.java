package fr.epsi.poe.mobile.javaproject.restaurant.controllers;

import fr.epsi.poe.mobile.javaproject.restaurant.models.Restaurant;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

/**
 * @author Yannis Mazzer <yannis@ioweb.fr>
 * @created_on 19/07/16
 */
public class RestaurantControllerTest {

    private RestaurantController restaurantController = new RestaurantController();

    @Test
    public void shouldThrowExceptionWhenIllegalParametersArePassed() throws Exception {

        // Throws exception when both parameters are null
        try {
            restaurantController.getRestaurants(null, null);
            fail("No exception were thrown whereas it should have");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("latitude and longitude parameters cannot be empty")
                    .hasNoCause();
        }
        // Throws exception when latitude is null
        try {
            restaurantController.getRestaurants(null, 0.0);
            fail("No exception were thrown whereas it should have");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("latitude and longitude parameters cannot be empty")
                    .hasNoCause();
        }
        // Throws exception when longitude is null
        try {
            restaurantController.getRestaurants(0.0, null);
            fail("No exception were thrown whereas it should have");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("latitude and longitude parameters cannot be empty")
                    .hasNoCause();
        }
        // Throws exception when both parameters are null
        try {
            restaurantController.getRestaurants(0.0, 0.0);
            fail("No exception were thrown whereas it should have");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("latitude and longitude parameters cannot be 0")
                    .hasNoCause();
        }
        // Throw exception when latitude is 0
        try {
            restaurantController.getRestaurants(0.0, 12.3);
            fail("No exception were thrown whereas it should have");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("latitude and longitude parameters cannot be 0")
                    .hasNoCause();
        }
        // Throw exception when longitude is 0
        try {
            restaurantController.getRestaurants(12.3, 0.0);
            fail("No exception were thrown whereas it should have");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("latitude and longitude parameters cannot be 0")
                    .hasNoCause();
        }
    }

    @Test
    public void shouldReturnAListOfRestaurants() throws Exception {
        List<Restaurant> response = restaurantController.getRestaurants(12.3, 3.12);
        assertThat(response).isNotNull().isEmpty();
    }
}