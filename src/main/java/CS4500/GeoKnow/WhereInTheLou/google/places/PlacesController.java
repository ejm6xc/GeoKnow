package CS4500.GeoKnow.WhereInTheLou.google.places;

import CS4500.GeoKnow.WhereInTheLou.util.GeoJsonConverter;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/places")
public class PlacesController {

    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchPlaces(@RequestParam("query") String query) throws ApiException, InterruptedException, IOException {
        PlacesSearchResponse response = placesService.searchPlaces(query);
        return GeoJsonConverter.toGeoJson(response);
    }
}
