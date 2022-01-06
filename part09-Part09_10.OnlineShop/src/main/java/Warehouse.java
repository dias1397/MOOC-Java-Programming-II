
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class Warehouse {
    
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Warehouse() {
        prices = new HashMap<>();
        stocks = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        stocks.put(product, stock);
    }
    
    public boolean take(String product) {
        if (stock(product) == 0) {
            return false;
        } else {
            stocks.put(product, stocks.get(product)-1);
            if (stock(product) == 0) {
                stocks.remove(product);
                prices.remove(product);
            }
        }
        return true;
    }
    
    public int price(String product) {
        return prices.get(product) != null ? prices.get(product) : -99;
    }
    
    public int stock(String product) {
        return stocks.get(product) != null ? stocks.get(product) : 0;
    }
    
    public Set<String> products() {
        return prices.keySet();
    }
    
}
