package net.perata.entity;

public  abstract class Product {
    private  int  price;

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public abstract String getName();
}

