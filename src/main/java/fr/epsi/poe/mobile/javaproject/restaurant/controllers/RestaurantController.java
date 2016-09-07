package fr.epsi.poe.mobile.javaproject.restaurant.controllers;

import fr.epsi.poe.mobile.javaproject.restaurant.models.Restaurant;
import fr.epsi.poe.mobile.javaproject.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yannis Mazzer <yannis@ioweb.fr>
 * @created_on 19/07/16
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/nearby", method = RequestMethod.GET)
    public List<Restaurant> getRestaurants(@RequestParam Double latitude, @RequestParam Double longitude) throws Exception {
        if(latitude == null || longitude == null) {
            throw new IllegalArgumentException("latitude and longitude parameters cannot be empty");
        }
        if(latitude == 0 || longitude == 0) {
            throw new IllegalArgumentException("latitude and longitude parameters cannot be 0");
        }
        return restaurantService.getRestaurantsFromGoogle(latitude, longitude);
    }

    protected String test() {
        return "plop";
    }


}
