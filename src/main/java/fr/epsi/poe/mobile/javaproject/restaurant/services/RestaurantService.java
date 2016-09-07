package fr.epsi.poe.mobile.javaproject.restaurant.services;

import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PhotoRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.*;
import fr.epsi.poe.mobile.javaproject.restaurant.models.Restaurant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yannis Mazzer <yannis@ioweb.fr>
 * @created_on 19/07/16
 */
@Service
public class RestaurantService {

    @Value("${myapp.google_api_key}")
    private String apiKey;


    @Value("${myapp.google_openNow}")
    private Boolean openNow;

    @Value("${myapp.google_radius}")
    private Integer radius;

    public List<Restaurant> getRestaurantsFromGoogle(Double latitude, Double longitude) throws Exception {

        List<Restaurant> res = new ArrayList<>();

        List<PlacesSearchResult> results = findRestaurantNearBy(latitude, longitude);

        results.stream().forEach(
                placesSearchResult -> res.add(
                        new Restaurant(
                                placesSearchResult.name,
                                placesSearchResult.vicinity,
                                placesSearchResult.icon.toString(),
                                (placesSearchResult.photos != null && placesSearchResult.photos.length > 0)
                                        ? placesSearchResult.photos[0].photoReference
                                        : "")
                )
        );
        return updateRestaurantsWithPhoto(res);
    }

    public List<PlacesSearchResult> findRestaurantNearBy(Double latitude, Double longitude) throws Exception {
        GeoApiContext geoApiContext = new GeoApiContext().setApiKey(apiKey);
        NearbySearchRequest request = PlacesApi.nearbySearchQuery(geoApiContext, new LatLng(latitude, longitude))
                .openNow(this.openNow)
                .radius(this.radius)
                .type(PlaceType.RESTAURANT);
        PlacesSearchResponse response = request.await();

//        response.results.stream().forEach()

        return Arrays.asList(response.results);
    }

    public List<Restaurant> updateRestaurantsWithPhoto(List<Restaurant> restaurants) throws Exception {
        List<Restaurant> res = new ArrayList<>();

        restaurants.stream().forEach(restaurant -> {
            try {
                res.add(updateRestaurantWithPhoto(restaurant));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return res;
    }

    public Restaurant updateRestaurantWithPhoto(Restaurant restaurant) throws Exception {
        GeoApiContext geoApiContext = new GeoApiContext().setApiKey(apiKey);
        if (!"".equals(restaurant.getPhotoReference())) {
            PhotoRequest request = PlacesApi.photo(geoApiContext, restaurant.getPhotoReference());
            request.maxHeight(1600);
            PhotoResult photoResult = request.await();
            restaurant.setPhoto(photoResult.imageData);
            restaurant.setPhotoType(photoResult.contentType);
            return restaurant;
        } else {
            return restaurant;
        }
    }
}