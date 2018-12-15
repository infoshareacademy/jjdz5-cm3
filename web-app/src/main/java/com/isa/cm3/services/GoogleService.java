package com.isa.cm3.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.isa.cm3.delegations.GeoLocation;

import javax.ejb.Stateful;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateful
public class GoogleService {

    private InputStream inputStream;
    private StringBuilder sbuild = new StringBuilder();

    private List<String> lista = new ArrayList<>();
    private Map<String, Double> geoMap = new HashMap<>();
    private String urlString;

    private GeoLocation geoLocation;

    public GeoLocation parseJson(String city) {

        try {

            urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=" + city + "&key=AIzaSyBu0sYuR-4seTsRxjdW4ai0fzncoOoBWgw";

            URL url = new URL(urlString);
            inputStream = url.openStream();
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            JsonReader jsonReader = new JsonReader(reader);

            JsonObject jb = Streams.parse(jsonReader).getAsJsonObject();

            JsonArray jsonObject1 = jb.getAsJsonArray("results");

            JsonObject jsonObject2 = (JsonObject) jsonObject1.get(0);
            JsonObject jsonObject3 = (JsonObject) jsonObject2.get("geometry");
            JsonObject location = (JsonObject) jsonObject3.get("location");
            geoLocation = new GeoLocation(location.get("lat").getAsDouble(), location.get("lng").getAsDouble());

            inputStream.close();
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return geoLocation;
    }
}