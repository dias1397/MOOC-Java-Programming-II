/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dias97
 */
public class SaveableDictionary {
    
    private Map<String, String> translations1;
    private Map<String, String> translations2;
    private String file;

    public SaveableDictionary() {
        translations1 = new HashMap<>();
        translations2 = new HashMap<>();
    }
    
    public SaveableDictionary(String file) {
        translations1 = new HashMap<>();
        translations2 = new HashMap<>();
        this.file = file;
    }
    
    public boolean load() {
        try (Scanner fileReader = new Scanner(new File(file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (!line.equals("")) {
                    String[] parts = line.split(":");   // split the line based on the ':' character

                    //System.out.println(parts[0]);     // part of line before :
                    //System.out.println(parts[1]);     // part of line after :

                    add(parts[0], parts[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            return false;
        }
                
        return true;
    }
    
    public boolean save() {
        try (PrintWriter writer = new PrintWriter(file)) {
            translations1.keySet().forEach((word) -> {
                writer.println(word + ":" + translations1.get(word));
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
                
        return true;
    }
    
    public void add(String words, String translation) {
        if(translate(words) == null) {
            translations1.put(words, translation);
            translations2.put(translation, words);
        }
    }
    
    public String translate(String word) {
        return translations1.getOrDefault(word, translations2.getOrDefault(word, null));
    }
    
    public void delete(String word) {
        String translation = translations1.getOrDefault(word, translations2.getOrDefault(word, null));
        if (translation != null ) {
            translations1.remove(word);
            translations1.remove(translation);
            translations2.remove(word);
            translations2.remove(translation);
        }
    }
}
