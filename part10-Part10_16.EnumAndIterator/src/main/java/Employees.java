
import java.util.ArrayList;
import java.util.Iterator;
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
public class Employees {
    
    private List<Person> persons;

    public Employees() {
        persons = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        persons.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        persons.addAll(peopleToAdd);
    }
    
    public void print() {
        persons.stream().forEach(System.out::println);
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = persons.iterator();
        
        while(iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getEducation().equals(education)) {
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = persons.iterator();
        
        while(iterator.hasNext()) {
            if (iterator.next().getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
}
