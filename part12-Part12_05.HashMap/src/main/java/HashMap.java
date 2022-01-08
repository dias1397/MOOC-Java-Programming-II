
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
public class HashMap<K, V> {
    
    private List<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new ArrayList[32];
        this.firstFreeIndex = 0;
    }
    
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }
        
        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];
        
        for (Pair pair : valuesAtIndex) {
            if (pair.getKey().equals(key)) {
                return (V) pair.getValue();
            }
        }
        
        return null;
    }
    
    public void add(K key, V value) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);
        
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
        
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }
    
    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }
        
        return this.values[hashValue];
    }
    
    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        for (Pair pair : myList) {
            if (pair.getKey().equals(key)) {
                return myList.indexOf(pair);
            }
        }
        
        return -1;
    }
    
    private void grow() {
        List<Pair<K, V>>[] newValues = new ArrayList[this.values.length * 2];
        
        for (int i = 0; i < this.values.length; i++) {
            copy(newValues, i);
        }
        
        this.values = newValues;
    }
    
    private void copy(List<Pair<K, V>>[] newArray, int fromIndex) {
        if (this.values[fromIndex] == null) {
            return;
        }
        
        for (int i = 0; i < this.values[fromIndex].size(); i++) {
            Pair<K, V> value = this.values[fromIndex].get(i);

            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if(newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }

            newArray[hashValue].add(value);
        }
    }
    
    public V remove(K key) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
    
}
