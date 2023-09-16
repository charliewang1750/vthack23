package com.zillow.vthack23;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class Amazon {


    Product product1 = new Product("book", 21.2);
    Product product2 = new Product("table",  40);

    private ArrayList<Product> stuff = new ArrayList<Product>();


    public ArrayList<Product> printList(){
        //prints stuff
        stuff.add(product1);
        stuff.add(product2);
        return stuff;
    }

    /*public void addRandom(){
        //adds random product to stuff
        Product newProduct = new Product();
        stuff.add(newProduct);
        return;
    }
*/
    

}
