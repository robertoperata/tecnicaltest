package net.perata.entity;

import net.perata.messenger.Messenger;

public class Apple extends Product {
    public Apple(int price){
        this.setPrice(price);
    }
    @Override
    public String getName() {
        return "Apple";
    }



}
