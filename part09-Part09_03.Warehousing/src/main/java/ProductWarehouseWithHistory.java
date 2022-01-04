
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class ProductWarehouseWithHistory extends ProductWarehouse{
    
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String name, double capacity, double initialBalance) {
        super(name, capacity);
        super.addToWarehouse(initialBalance);
        history = new ChangeHistory();
        history.add(initialBalance);
    }
    
    public String history() {
        return history.toString();
    } 
    
    public void addToWarehouse(double amount) {
        if (amount < 0) {
            return;
        }
        super.addToWarehouse(amount);
        history.add(super.getBalance());
    }
    
    public double takeFromWarehouse(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        double amountTaken = super.takeFromWarehouse(amount);
        history.add(super.getBalance());
        return amountTaken;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + history.toString());
        System.out.println("Largest amount of product: " + history.maxValue());
        System.out.println("Smallest amount of product: " + history.minValue());
        System.out.println("Average: " + history.average());
    }
    
}
