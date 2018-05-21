package net.perata.entity;

public class Bar extends Product {
    public Bar(int price){
        this.setPrice(price);
    }
    @Override
    public String getName() {
        return "Bar";
    }
}
