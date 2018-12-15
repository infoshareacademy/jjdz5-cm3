package com.isa.cm3.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.isa.cm3.delegations.GeoLocation;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=elblag&key=AIzaSyBu0sYuR-4seTsRxjdW4ai0fzncoOoBWgw");
            URL url = new URL(urlString);

            inputStream = url.openStream();

            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                lista.add(line);
            }
            reader.close();
            bufferedReader.close();
            inputStream.close();
            for (String s : lista) {
                sbuild.append(s);
            }

            JsonParser parser = new JsonParser();
            JsonObject jb = (JsonObject) parser.parse(String.valueOf(sbuild));

            JsonArray jsonObject1 = jb.getAsJsonArray("results");
            JsonObject jsonObject2 = (JsonObject) jsonObject1.get(0);
            JsonObject jsonObject3 = (JsonObject) jsonObject2.get("geometry");
            JsonObject location = (JsonObject) jsonObject3.get("location");
            geoLocation = new GeoLocation(location.get("lat").getAsDouble(), location.get("lng").getAsDouble());

        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return geoLocation;
    }
}