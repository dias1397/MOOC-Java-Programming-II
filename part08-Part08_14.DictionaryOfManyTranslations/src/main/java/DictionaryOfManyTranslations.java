
import java.util.ArrayList;
import java.util.HashMap;
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
public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> dictionary;
    
    public DictionaryOfManyTranslations() {
        dictionary = new HashMap<>();
    }
    
    public void add(String word, String translation) {
        dictionary.putIfAbsent(word, new ArrayList<>());
        
        ArrayList<String> translations = dictionary.get(word);
        translations.add(translation);
        
        dictionary.put(word, translations);
    }
    
    public ArrayList<String> translate(String word) {
        return dictionary.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word) {
        if (dictionary.get(word) != null && !dictionary.get(word).isEmpty()) {
            dictionary.remove(word);
        }
    }
    
}
