/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class List<T> {
    
    private T[] items;
    private int firstItemIndex;

    public List() {
        items = (T[]) new Object[10]; 
        firstItemIndex = 0;
    }
    
    public void add(T item) {
        if (this.firstItemIndex == this.items.length) {
            expand();
        }
        
        this.items[firstItemIndex] = item;
        firstItemIndex++;
    }
    
    private void expand() {
        int newSize = this.items.length + this.items.length / 2;
        
        T[] newItems = (T[]) new Object[newSize];
        System.arraycopy(this.items, 0, newItems, 0, this.items.length);
        
        this.items = newItems;
    }
    
    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }
    
    public void remove(T item) {
        int index = indexOf(item);
        if (index < 0) {
            return;
        }
        
        moveToLeft(index);
        this.firstItemIndex--;
    }
    
    public int indexOf(T item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == item) {
                return i;
            }
        }
        
        return -1;
    }
    
    private void moveToLeft(int startIndex) {
        for (int i = startIndex; i < this.items.length - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
    }
    
    public int size() {
        return this.firstItemIndex;
    }
    
    public T value(int index) {
        if (index < 0 || index >= this.firstItemIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstItemIndex + "]");
        }

        return this.items[index];
    }
    
}
