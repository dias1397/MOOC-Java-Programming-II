
import java.util.ArrayList;
import java.util.Collections;
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
public class Hand implements Comparable<Hand>{
    
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        cards.stream().forEach(System.out::println);
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand arg0) {
        int hand1 = this.cards.stream()
                    .map(c -> c.getValue())
                    .reduce(0, Integer::sum);
        int hand2 = arg0.cards.stream()
                    .map(c -> c.getValue())
                    .reduce(0, Integer::sum);
        return hand1 - hand2;
    }
    
}
