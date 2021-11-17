
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
public class Abbreviations {

    private HashMap<String, String> abbreviations;
    
    public Abbreviations() {
        abbreviations = new HashMap<>();      
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviations.put(abbreviation, explanation);
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        return abbreviations.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        return abbreviations.get(abbreviation);
    }
    
}
