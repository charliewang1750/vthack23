package com.zillow.vthack23;
import java.util.ArrayList;
import java.lang.Math;

import org.springframework.stereotype.Service;

@Service
public class Amazon {


    Product product1 = new Product("book", 21.2);
    Product product2 = new Product("table", 40);

    private ArrayList<Product> stuff = new ArrayList<Product>();


    public ArrayList<Product> printList(){
        //prints stuff
        stuff.add(product1);
        stuff.add(product2);
        return stuff;
    }

    public double newLocation(){
        double longitude = Math.random() *180;
        //double latitude = (Math.random() * 90);
        return longitude;
    }
}
