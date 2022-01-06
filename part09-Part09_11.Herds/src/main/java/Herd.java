
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class Herd implements Movable{

    private List<Movable> herd;

    public Herd() {
        herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        herd.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        herd.stream().forEach(o -> o.move(dx, dy));
    }

    @Override
    public String toString() {
        return herd.stream().map((movable) -> movable.toString() + '\n').reduce("", String::concat);
    }
    
}
