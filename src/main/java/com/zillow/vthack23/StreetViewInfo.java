package com.zillow.vthack23;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class StreetViewInfo {
    private static final String GOOGLE_API_KEY = "AIzaSyA9NpNncXJgKB8vvBM1evqSWa9GZOerS1I";
    static LocationInfo locationInfo;// = new LocationInfo("","","",0,0);
    public static void main(String[] args) {
        double latitude = 11.23;//37.7749; // Replace with your latitude
        double longitude = 52.4241;//-122.4194; // Replace with your longitude

        try {
            locationInfo = getLocationInfo(latitude, longitude);
            if (locationInfo != null) {
                System.out.println("City/Country: " + locationInfo.city + ", " + locationInfo.country);
                System.out.println("Street View Image URL: " + locationInfo.streetViewImageUrl);
                System.out.println("Latitude: " + locationInfo.latitude);
                System.out.println("Longitude: " + locationInfo.longitude);
            } else {
                System.out.println("Unable to retrieve location information.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LocationInfo getLocationInfo(double latitude, double longitude) throws IOException {
        // Step 1: Get City/Country information using Geocoding API
        String geoCodingUrl = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latitude + "," + longitude + "&key=" + GOOGLE_API_KEY;
        String geoCodingResponse = sendHttpRequest(geoCodingUrl);
        
        JSONObject geoCodingJson = new JSONObject(geoCodingResponse);
        JSONArray results = geoCodingJson.getJSONArray("results");
        JSONObject result = results.getJSONObject(0);
        JSONArray addressComponents = result.getJSONArray("address_components");

        String city = "";
        String country = "";

        for (int i = 0; i < addressComponents.length(); i++) {
            JSONObject component = addressComponents.getJSONObject(i);
            JSONArray types = component.getJSONArray("types");

            if (types.toString().contains("locality")) {
                city = component.getString("long_name");
            }

            if (types.toString().contains("country")) {
                country = component.getString("long_name");
            }
        }

        if(city!=null && !city.isEmpty()){
            String nearestCityUrl = "https://maps.googleapis.com/maps/api/geocode/json?address="+city.replace(" ","+")+"&key=" + GOOGLE_API_KEY;
            String nearestCityResponse = sendHttpRequest(nearestCityUrl);
            JSONObject nearestCityJson = new JSONObject(nearestCityResponse);
            JSONArray cityResults = nearestCityJson.getJSONArray("results");

            if (cityResults.length() > 0) {
                JSONObject firstResult = cityResults.getJSONObject(0);
                JSONObject geometry = firstResult.getJSONObject("geometry");
                JSONObject location = geometry.getJSONObject("location");

                latitude = location.getDouble("lat");
                longitude = location.getDouble("lng");
            } 
            else {
                System.out.println("No results found for the city.");
            }
        }


        // Step 2: Get Street View Image URL
        String streetViewImageUrl = "https://maps.googleapis.com/maps/api/streetview?size=400x400&location=" + latitude + "," + longitude + "&key=" + GOOGLE_API_KEY;

        return new LocationInfo(city, country, streetViewImageUrl, latitude, longitude);
    }

    public static String sendHttpRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        StringBuilder response = new StringBuilder();

        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }

        scanner.close();
        connection.disconnect();

        return response.toString();
    }
}

class LocationInfo {
    String city;
    String country;
    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    String streetViewImageUrl;
    double latitude;
    double longitude;

    public LocationInfo(String city, String country, String streetViewImageUrl, double latitude, double longitude) {
        this.city = city;
        this.country = country;
        this.streetViewImageUrl = streetViewImageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
