package CS4500.GeoKnow.WhereInTheLou.google.places;

import com.google.maps.GeoApiContext;
import com.google.maps.TextSearchRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PlacesService {

    private final GeoApiContext geoApiContext;

    public PlacesService(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    public PlacesSearchResponse searchPlaces(String query) throws ApiException, InterruptedException, IOException {
        TextSearchRequest request = new TextSearchRequest(geoApiContext).query(query);
        return request.await();
    }
}
