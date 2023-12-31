package com.zillow.vthack23;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class randomLocation {
    
    ArrayList<Location> list = new ArrayList<>();
    Location location = new Location();
    LocationInfo locationInfo;

    @RequestMapping("/help")
    public String printString(){
        return null;
    }

    @RequestMapping("/random")
    @GetMapping("/random")
    public String location() throws IOException{
        String result = "";
        Location newLoc = new Location();
        
        LocationInfo locationInfo = StreetViewInfo.getLocationInfo(newLoc.getLatitude(), newLoc.getLongitude());
        list.add(newLoc);
        if (locationInfo != null) {
            result += "City/Country: " + locationInfo.city + ", " + locationInfo.country+"\n";
            result += "Street View Image URL: " + locationInfo.streetViewImageUrl+"\n";
            result +=  "Latitude: " + locationInfo.latitude+"\n";
            result += "Longitude: " + locationInfo.longitude+"\n";
        } else {
            result += "Unable to retrieve location information.\n";
        }
        System.out.println(locationInfo);
        return result;
    }

    @RequestMapping("/randomImage")
    public String randomLocImage() throws IOException{
        String result = "";
        Location newLoc = new Location();
        
        locationInfo = StreetViewInfo.getLocationInfo(newLoc.getLatitude(), newLoc.getLongitude());
        list.add(newLoc);
        if (locationInfo != null) {
            result += "City/Country: " + locationInfo.city + ", " + locationInfo.country+"\n";
            result += "Street View Image URL: " + locationInfo.streetViewImageUrl+"\n";
            result +=  "Latitude: " + locationInfo.latitude+"\n";
            result += "Longitude: " + locationInfo.longitude+"\n";
        } else {
            result += "Unable to retrieve location information.\n";
        }
        return locationInfo.streetViewImageUrl;
    }

    @RequestMapping("/getCity")
    public String getCity(){
        String result = locationInfo.getCity() + ", " + locationInfo.getCountry();
        if(result.equals(", ")){ 
            result = "NO CITY FOUND (PROBABLY OCEAN)";
        }
        return result;
    }

    @RequestMapping("/list")
    public String printList(){
        return list.toString();
    }

    @RequestMapping("/clear")
    public String removeItem(){
        list.clear();
        return list.toString();
    }

    @GetMapping("tragic")
    public String hi(){
        return "hi";
    }

}
