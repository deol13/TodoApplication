package se.lexicon.Data.Impl;

import se.lexicon.Data.PersonDAO;
import se.lexicon.Model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class PersonDAOImpl implements PersonDAO {
    private ArrayList<Person> personCollection;

    public PersonDAOImpl() {
        personCollection = new ArrayList<Person>();
    }

    @Override
    public Person persist(Person person) {
        if(person == null) throw new IllegalArgumentException("Error: Person object can't be null!");
        personCollection.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        int index = findIndexById(id);
        if(index > -1) return personCollection.get(index);
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person p : personCollection) {
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
        for (int i = 0; i < personCollection.size(); i++) {
            if(personCollection.get(i).getId() == id)
                return i;
        }
        return -1;
    }
}
