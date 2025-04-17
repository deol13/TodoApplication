package se.lexicon.Data;

import se.lexicon.Model.Person;
import java.util.Collection;

public interface PersonDAO<T> {

    T persist(T person);
    T findById(int id);
    T findByEmail (String email);
    Collection<T> findAll();
    void remove(int id);
}
