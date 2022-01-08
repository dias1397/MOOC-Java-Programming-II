
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class Pipe<T> {
    
    public Queue<T> queue;

    public Pipe() {
        queue = new ArrayDeque<>();
    }
    
    public void putIntoPipe(T value) {
        queue.add(value);
    }
    
    public T takeFromPipe() {
        return queue.poll();
    }
    
    public boolean isInPipe() {
        return !queue.isEmpty();
    }
    
}
