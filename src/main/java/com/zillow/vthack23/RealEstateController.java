package com.zillow.vthack23;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class RealEstateController {
    
    Amazon Amazon;

    @RequestMapping("/list")
    public ArrayList<Product> printList(){
        return Amazon.printList();
    }

    @RequestMapping("/help")
    public String printString(){
        return null;
    }

    @RequestMapping("/random")
    public double location(){
        return Amazon.newLocation();
    }

    /*@RequestMapping("/houses/random")
    public RealEstate info(){
        return;
    }*/
}
