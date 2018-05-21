package net.perata.model;

import net.perata.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static Data instance = null;
    private static List<Product> sales = new ArrayList<Product>();

    private Data(){};

    public static Data getInstance(){
        if(instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public List<Product> getSales(){
        return sales;
    }

    public void addSale(Product product){
       sales.add(product);
    }

    public Product getData(int id){
        return sales.get(id);
    }
}
