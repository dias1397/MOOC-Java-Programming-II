
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class VehicleRegistry {

    private HashMap<LicensePlate, String> registry;
    
    public VehicleRegistry() {
        registry = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (registry.containsKey(licensePlate)) {
            return false;
        }
        registry.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate) {
        return registry.getOrDefault(licensePlate, null);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (!registry.containsKey(licensePlate)) {
            return false;
        }
        registry.remove(licensePlate);
        return true;
    }
    
    public void printLicensePlates() {
        registry.keySet().stream()
                .forEach(System.out::println);
    }
    
    public void printOwners() {
        registry.values().stream()
                .distinct()
                .forEach(System.out::println);
    }
    
}
