package net.perata.factory;

import net.perata.entity.Apple;
import net.perata.entity.Bar;
import net.perata.entity.Foo;
import net.perata.entity.Product;

public class ProductFactory {

    public Product getProduct(String productType, int price){
        if(productType.equalsIgnoreCase("Foo")){
            return new Foo(price);
        }else if(productType.equalsIgnoreCase("Bar")){
            return new Bar(price);
        }else if(productType.equalsIgnoreCase("Apple")){
            return new Apple(price);
        }
        return null;
    }


}
