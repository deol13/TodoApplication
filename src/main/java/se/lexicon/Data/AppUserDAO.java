package se.lexicon.Data;

import se.lexicon.Model.AppUser;
import java.util.Collection;

public interface AppUserDAO<T> {

    void persist(T appUser);
    T findByUsername(String username);
    Collection<T> findAll();
    void remove(String username);
}
