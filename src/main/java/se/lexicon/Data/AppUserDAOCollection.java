package se.lexicon.Data;

import se.lexicon.Model.AppUser;

import java.util.*;

public class AppUserDAOCollection implements AppUserDAO {
    private ArrayList<AppUser> appUserCollection;

    public AppUserDAOCollection() {
        appUserCollection = new ArrayList<AppUser>();
    }

    @Override
    public void persist(AppUser appUser) {
        if(appUser == null) throw new IllegalArgumentException("Error: AppUser object can't be null!");
        appUserCollection.add(appUser);
    }

    @Override
    public AppUser findByUsername(String username) {
        int index = findIndexByUserName(username);
        if(index > -1)
            return appUserCollection.get(index);
        else
            return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return appUserCollection;
    }

    @Override
    public void remove(String username) {
        int index = findIndexByUserName(username);
        if(index > -1) appUserCollection.remove(index);
    }

    private int findIndexByUserName(String username){
        for (int i = 0; i < appUserCollection.size(); i++) {
            if(appUserCollection.get(i).getUsername().equals(username))
                return i;
        }
        return -1;
    }

    //appUserCollection.forEach(i -> {if(i.getUsername().equals(username)) { appUserCollection.remove(i); }}); I can't stop it from removing more than one.

    //Just a test to see if I could find a lambda solution.
//        Object result = appUserCollection.stream().filter( obj ->
//            obj.getUsername().equals(username))
//                .findFirst();
//        return (AppUser) result; //result is empty if nothing is found, not sure how handle that.
}
