package se.lexicon.Data;

import se.lexicon.Model.AppUser;
import java.util.Collection;

public interface AppUserDAO {

    AppUser persist(AppUser appUser);
    AppUser findByUsername(String username);
    Collection<AppUser> findAll();
    void remove(String username);
}
