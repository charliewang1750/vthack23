package com.zillow.vthack23;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class randomLocation {
    
    ArrayList<Location> list = new ArrayList<>();
    Location location = new Location();

    @RequestMapping("/help")
    public String printString(){
        return null;
    }

    @RequestMapping("/random")
    public String location(){
        Location newLoc = new Location();
        list.add(newLoc);
        return newLoc.toString();
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
}
