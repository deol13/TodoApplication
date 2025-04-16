package se.lexicon.Data.Impl;

import se.lexicon.Data.AppUserDAO;
import se.lexicon.Model.AppUser;

import java.util.*;

public class AppUserDAOImpl implements AppUserDAO<AppUser> {
    private ArrayList<AppUser> appUserCollection;

    public AppUserDAOImpl() {
        appUserCollection = new ArrayList<AppUser>();
    }

    @Override
    public void persist(AppUser appUser) {
        if(appUser == null) throw new IllegalArgumentException("Error: AppUser object can't be null!");

        Optional<AppUser> user = findUserByUserName(appUser.getUsername());
        if(user.isPresent()) throw new IllegalArgumentException("Error: An app user with that name already exists");
        appUserCollection.add(appUser);
    }

    @Override
    public AppUser findByUsername(String username) {
        Optional<AppUser> user = findUserByUserName(username);

        return user.orElse(null);
    }

    @Override
    public Collection<AppUser> findAll() {
        return appUserCollection;
    }

    @Override
    public void remove(String username) {
        Optional<AppUser> user = findUserByUserName(username);
        user.ifPresent(appUser -> appUserCollection.remove(appUser));
    }

    private Optional<AppUser> findUserByUserName(String username){
        List<AppUser> users = appUserCollection.stream().filter(u -> u.getUsername().equals(username)).toList();

        if(users.size() == 1)
            return Optional.ofNullable(users.get(0));

        return Optional.empty();
    }

    //appUserCollection.forEach(i -> {if(i.getUsername().equals(username)) { appUserCollection.remove(i); }}); I can't stop it from removing more than one.

    //Just a test to see if I could find a lambda solution.
//        Object result = appUserCollection.stream().filter( obj ->
//            obj.getUsername().equals(username))
//                .findFirst();
//        return (AppUser) result; //result is empty if nothing is found, not sure how handle that.
}
