
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
public class TodoList {
    
    private List<String> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }
    
    public void add(String task) {
        if (task != null) {
            tasks.add(task);
        }
    }
    
    public void print() {
        for (int i=0 ; i<tasks.size() ; i++) {
            System.out.println((i+1) + ": " + tasks.get(i));
        }
    }
    
    public void remove(int number) {
        if (tasks.size() >= number) {
            tasks.remove(number - 1);
        }
    }
}
