/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class Student extends Person{
    
    private int credits;

    public Student(String name, String address) {
        super(name, address);
        credits = 0;
    }
    
    public void study() {
        credits++;
    }
    
    public int credits() {
        return credits;
    }

    @Override
    public String toString() {
        return this.getName() + "\n  " + this.getAddress() + "\n  Study credits " + credits;
    }
    
    
    
}
