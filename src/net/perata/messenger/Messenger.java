package net.perata.messenger;

import net.perata.entity.Product;
import net.perata.model.Data;

import java.util.*;

public class Messenger {
    private static final int PAUSING_APP = 50;
    private static final int MESSAGE_ON_THERSHOLD = 10;
    private static int CURRENT_SALES = 0;

    /**
     * after receiving a sales send message:
     * Basic logic to choose the messages
     *
     * @param product
     */
    public void processMessage(Product product){
        Data data = Data.getInstance();
        if(Messenger.CURRENT_SALES < Messenger.PAUSING_APP -1) {
            data.addSale(product);
            Messenger.CURRENT_SALES++;
            message1(product);

            if(Messenger.CURRENT_SALES % Messenger.MESSAGE_ON_THERSHOLD == 0){
                message2();
            }
        }else{
            messagePausing();
        }
    }

    /**
     * Retrive the list of sales and group by Object type
     * @return
     */
    private  Hashtable<String, ArrayList<Product>> arrangeSells() {
        Data data = Data.getInstance();
        Hashtable<String, ArrayList<Product>> ht = new Hashtable<String, ArrayList<Product>>();
        for (Product p : data.getSales()) {
            if(ht.get(p.getName()) == null){
                ArrayList<Product> product = new ArrayList<>();
                product.add(p);
                ht.put(p.getName(), product);
            }else{
                ArrayList<Product> product = ht.get(p.getName());
                product.add(p);
            }
        }
        return ht;
    }

    private void messagePausing() {
        System.out.println("Max order riched: application is paused");
        message3();
    }

    private void message1(Product product){
        System.out.println("1 sales of " + product.getName() + " at " + product.getPrice());
    }


    private void message2() {
        System.out.println("---------------");
        Hashtable<String, ArrayList<Product>> ht = arrangeSells();
        Iterator p = ht.entrySet().iterator();
        while (p.hasNext()) {
            Map.Entry product = (Map.Entry) p.next();
            ArrayList<Product> list = (ArrayList<Product>) product.getValue();
            int count = 0;
            int total = 0;
            for (int i = 0; i < list.size(); i++) {
                count++;
                total += list.get(i).getPrice();
            }
            System.out.println(count + " sales of " + product.getKey() + " for a total of " + total);
        }
        System.out.println("---------------");
    }

        private void message3() {
            System.out.println("---------------");
            Hashtable<String, ArrayList<Product>> ht = arrangeSells();
            Iterator p = ht.entrySet().iterator();
            while (p.hasNext()) {
                Map.Entry product = (Map.Entry) p.next();
                ArrayList<Product> list = (ArrayList<Product>) product.getValue();
                int referencePrice = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (i > 0) {
                        int diff = list.get(i).getPrice() - referencePrice;
                        if (diff != 0) {
                            System.out.println(product.getKey() + " adjusment of " + diff);
                        }
                    }
                    referencePrice = list.get(i).getPrice();
                }
            }
        }
}
