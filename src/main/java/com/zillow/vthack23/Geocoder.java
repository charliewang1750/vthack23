package com.zillow.vthack23;

import static com.google.maps.TestUtils.retrieveBody;
import static com.google.maps.model.ComponentFilter.administrativeArea;
import static com.google.maps.model.ComponentFilter.country;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import com.google.maps.internal.HttpHeaders;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.AddressType;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.LocationType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import okhttp3.Headers;
import org.junit.Test;
import org.junit.experimental.categories.Category;


//AIzaSyA9NpNncXJgKB8vvBM1evqSWa9GZOerS1I

public class Geocoder {
    // curl -X POST -d locate="55.6802779000,12.5900501000" \
    //     -d geoit="XML" \
    //     https://geocode.xyz

    public static String executePost(String targetURL, String urlParameters) {

        GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyA9NpNncXJgKB8vvBM1evqSWa9GZOerS1I")
            .build();
        HttpURLConnection connection = null;
        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", 
            "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", 
            Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");  

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
            connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response  
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
