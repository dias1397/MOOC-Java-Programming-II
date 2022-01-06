
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
public class Box implements Packable{
    
    private double capacity;
    private ArrayList<Packable> content;

    public Box(double capacity) {
        this.capacity = capacity;
        this.content = new ArrayList<>();
    }
    
    public void add(Packable item) {
        if ((weight() + item.weight()) <= capacity) {
            content.add(item);
        }
    }
    
    @Override
    public double weight() {
        return content.stream().mapToDouble(i -> i.weight()).sum();
    }

    @Override
    public String toString() {
        return "Box: " + content.size() + " items, total weight " + weight() + " kg";
    }
    
    
    
}
