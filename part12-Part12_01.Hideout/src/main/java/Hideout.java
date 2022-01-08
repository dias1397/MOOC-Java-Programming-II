/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class Hideout<T> {
    
    private T hiddenObject;

    public Hideout() {
    
    }
    
    public void putIntoHideout(T toHide) {
        hiddenObject = toHide;
    }
    
    public T takeFromHideout() {
        T result = hiddenObject;
        hiddenObject = null;
        return result;
    }
    
    public boolean isInHideout() {
        return hiddenObject != null;
    }
}
