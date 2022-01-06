
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
public class BoxWithMaxWeight extends Box{
    
    private int capacity;
    private ArrayList<Item> content;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.content = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        int balance = content.stream().map(i -> i.getWeight()).reduce(0, Integer::sum);
        if ((balance + item.getWeight()) <= capacity) {
            content.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item i : content) {
            if (i.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
