package fr.epsi.poe.mobile.javaproject.restaurant.services;

import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yannis Mazzer <yannis@ioweb.fr>
 * @created_on 13/07/16
 */
@Service
public class GooglePlacesProxy {

    @Value("${myapp.google_api_key}")
    private String googleApiKey;

    public List<PlacesSearchResult> findRestaurantNearBy() throws Exception {
        GeoApiContext geoApiContext = new GeoApiContext().setApiKey(googleApiKey);
        NearbySearchRequest request = PlacesApi.nearbySearchQuery(geoApiContext, new LatLng(45.7695369,4.8593714))
                .openNow(true)
                .radius(3000)
                .type(PlaceType.BAKERY);

        PlacesSearchResponse response = request.await();
        return Arrays.asList(response.results);
    }
}
