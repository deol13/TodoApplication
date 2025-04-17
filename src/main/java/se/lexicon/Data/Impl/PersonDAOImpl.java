package se.lexicon.Data.Impl;

import se.lexicon.Data.PersonDAO;
import se.lexicon.Model.AppUser;
import se.lexicon.Model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PersonDAOImpl implements PersonDAO<Person> {
    private ArrayList<Person> personCollection;

    public PersonDAOImpl() {
        personCollection = new ArrayList<Person>();
    }

    @Override
    public void persist(Person person) {
        if(person == null) throw new IllegalArgumentException("Error: Person object can't be null!");
        personCollection.add(person);
    }

    @Override
    public Person findById(int id) {
        Optional<Person> person = findPersonById(id);
        if(person.isPresent()) return person.get();
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        Optional<Person> personOptional = personCollection.stream().filter(p -> p.getEmail().equals(email)).findFirst();

        return personOptional.orElse(null);
    }

    @Override
    public Collection<Person> findAll() {
        return personCollection;
    }

    @Override
    public void remove(int id) {
        Optional<Person> person = findPersonById(id);
        if(person.isPresent()) personCollection.remove(person.get());
    }

    private Optional<Person> findPersonById(int id){
        return personCollection.stream().filter(u -> u.getId() == id).findFirst();
    }
}
