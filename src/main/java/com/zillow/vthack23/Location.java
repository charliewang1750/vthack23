package com.zillow.vthack23;
import java.util.ArrayList;
import java.lang.Math;

import org.springframework.stereotype.Service;

@Service
public class Location {

    private double longitude;
    private double latitude;
    ArrayList<Location> list = new ArrayList<>();

    public Location(){
        this.longitude = randomLongitude();
        this.latitude = randomLatitude();
    }

    public String toString(){
        return "Longitude: " + longitude + " Latitude: " + latitude;
    }

    public double randomLongitude(){
        double longitude = Math.random() * 180;
        longitude = Math.floor(longitude * 10000)/10000;
        if(Math.random() > 0.5){
            longitude = -1 * longitude;
        }
        return longitude;
    }

    public double randomLatitude(){
        double latitude = Math.random() * 90;
        latitude = Math.floor(latitude * 10000)/10000;
        if(Math.random() > 0.5){
        latitude = -1 * latitude;
        }
        return latitude;
    }
}
