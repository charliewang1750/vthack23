package com.zillow.vthack23;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealEstateController {
    
    @RequestMapping("/list")
    public String hello(){
        return "hello";
    }

    /*@RequestMapping("/houses/random")
    public RealEstate info(){
        return;
    }*/
}
