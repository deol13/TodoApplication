package se.lexicon.Data;

import se.lexicon.Model.AppUser;
import se.lexicon.Model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements PersonDAO{
    private ArrayList<Person> personCollection;

    public PersonDAOCollection() {
        personCollection = new ArrayList<Person>();
    }

    @Override
    public void persist(Person person) {
        if(person == null) throw new IllegalArgumentException("Error: Person object can't be null!");
        personCollection.add(person);
    }

    @Override
    public Person findById(int id) {
        int index = findIndexById(id);
        if(index > -1) return personCollection.get(index);
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        Person[] persons = (Person[]) personCollection.toArray();
        for (Person p : persons) {
            if(p.getEmail().equals(email))
                return p;
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return personCollection;
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        if(index > -1) personCollection.remove(index);
    }

    private int findIndexById(int id){
        Person[] arr = (Person[]) personCollection.toArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getId() == id)
                return i;
        }
        return -1;
    }
}
