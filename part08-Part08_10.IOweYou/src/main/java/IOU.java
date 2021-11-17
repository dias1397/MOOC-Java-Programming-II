
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
public class IOU {

    private HashMap<String, Double> ownMap;
    
    public IOU() {
        ownMap = new HashMap<>();    
    }

    public void setSum(String toWhom, double amount) {
        ownMap.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return ownMap.getOrDefault(toWhom, 0.0);
    }
    
}
