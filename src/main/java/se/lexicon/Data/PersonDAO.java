package se.lexicon.Data;

import se.lexicon.Model.Person;
import java.util.Collection;

public interface PersonDAO {

    Person persist(Person person);
    Person findById(int id);
    Person findByEmail (String email);
    Collection<Person> findAll();
    void remove(int id);
}
