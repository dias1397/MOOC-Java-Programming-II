
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> facility;

    public StorageFacility() {
        facility = new HashMap<>();    
    }
    
    public void add(String unit, String item) {
        facility.putIfAbsent(unit, new ArrayList<>());
        
        ArrayList<String> items = facility.get(unit);
        items.add(item);
        
        facility.put(unit, items);
    }
    
    public ArrayList<String> contents(String storageUnit)  {
        return facility.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        ArrayList<String> items = facility.getOrDefault(storageUnit, new ArrayList<>());
        
        for (int i=0; i<items.size(); i++) {
            if (items.get(i).equals(item)) {
                items.remove(i);
                break;
            }
        }
        
        if (facility.getOrDefault(storageUnit, new ArrayList<>()).isEmpty() ) {
            facility.remove(storageUnit);
        }        
    }
    
    public ArrayList<String> storageUnits() {
        return (ArrayList<String>) facility.keySet().stream()
                .filter(k -> !facility.get(k).isEmpty())
                .collect(Collectors.toList());
    }
    
}
