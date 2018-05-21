package net.perata.entity;

public class Foo extends Product {
    public Foo(int price){
        this.setPrice(price);
    }

    @Override
    public String getName() {
        return "Foo";
    }
}
