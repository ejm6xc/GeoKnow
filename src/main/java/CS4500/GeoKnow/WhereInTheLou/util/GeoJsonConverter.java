package CS4500.GeoKnow.WhereInTheLou.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

public class GeoJsonConverter {

    public static String toGeoJson(PlacesSearchResponse response) {
        JsonObject featureCollection = new JsonObject();
        featureCollection.addProperty("type", "FeatureCollection");
        JsonArray features = new JsonArray();
        featureCollection.add("features", features);

        for (PlacesSearchResult result : response.results) {
            JsonObject feature = new JsonObject();
            feature.addProperty("type", "Feature");
            JsonObject geometry = new JsonObject();
            geometry.addProperty("type", "Point");
            JsonArray coordinates = new JsonArray();
            coordinates.add(result.geometry.location.lng);
            coordinates.add(result.geometry.location.lat);
            geometry.add("coordinates", coordinates);
            feature.add("geometry", geometry);
            JsonObject properties = new JsonObject();
            properties.addProperty("name", result.name);
            properties.addProperty("address", result.formattedAddress);
            feature.add("properties", properties);
            features.add(feature);
        }

        Gson gson = new Gson();
        return gson.toJson(featureCollection);
    }
}
