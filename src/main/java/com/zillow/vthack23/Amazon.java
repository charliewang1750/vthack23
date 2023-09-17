package com.zillow.vthack23;
import java.util.ArrayList;
import java.lang.Math;

import org.springframework.stereotype.Service;

@Service
public class Amazon {

    private double longitude;
    private double latitude;

    public Amazon(){
        this.longitude = randomLongitude();
        this.latitude = randomLatitude();
    }

    public String toString(){
        return "Longitude: " + longitude + " Latitude: " + latitude;
    }

    public double randomLongitude(){
        double longitude = Math.random() * 180;
        return longitude;
    }

    public double randomLatitude(){
        double latitude = Math.random() * 90;
        return latitude;
    }
}
