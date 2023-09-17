package com.zillow.vthack23;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class RealEstateController {
    
    Amazon Amazon = new Amazon();

    @RequestMapping("/help")
    public String printString(){
        return null;
    }

    @RequestMapping("/random")
    public String location(){
        return Amazon.toString();
    }

    /*@RequestMapping("/houses/random")
    public RealEstate info(){
        return;
    }*/
}
