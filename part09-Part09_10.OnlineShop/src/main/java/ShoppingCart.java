
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class ShoppingCart {
    
    private Map<String, Item> content;

    public ShoppingCart() {
        content = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (content.get(product) == null) {
            content.put(product, new Item(product, 0, price));
        }
        Item item = content.get(product);
        item.increaseQuantity();
        content.put(product, item);
    }
    
    public int price() {
        return content.values().stream().map(i -> i.price()).reduce(0, Integer::sum);
    }
    
    public void print() {
        content.values().forEach((item) -> {
            System.out.println(item.toString());
        });
    }
    
}
