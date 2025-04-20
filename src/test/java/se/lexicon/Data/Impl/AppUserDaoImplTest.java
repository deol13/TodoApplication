package se.lexicon.Data.Impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Model.AppRole;
import se.lexicon.Model.AppUser;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserDaoImplTest {
    @Test
    @DisplayName("Should save/persist an app user successfully")
    void persistAppUserSuccessfully(){
        // Scenario: Create an object of the AppUser class
        AppUser appUserData = new AppUser("testUserName", "testPassword", AppRole.ROLE_APP_USER);

        // Expected:
        AppUserDAOImpl appUserDAO = new AppUserDAOImpl();
        AppUser createdAppUser = appUserDAO.persist(appUserData);

        // Verify: Check created app user matches original input
        assertEquals(appUserData, createdAppUser);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException because app user object is null")
    void persistAppUserWithNullObjectThrowException(){
        // Scenario:

        // Expected:
        AppUserDAOImpl appUserDAO = new AppUserDAOImpl();
        String exceptionMessage = "Error: AppUser object can't be null!";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> appUserDAO.persist(null));
        String actualExceptionMessage = exception.getMessage();

        // Verify: Check that the exception message is correct
        assertEquals(exceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Should find an app user by username when the app user exists")
    void findByUsernameAppUserReturnsWhenExists() {
        // Scenario: Create AppUser object, AppUserDAOImpl object then add the AppUser object to the AppUserDAOImpl object
        AppUser appUserData = new AppUser("testUserName", "testPassword", AppRole.ROLE_APP_USER);
        AppUserDAOImpl appUserDAO = new AppUserDAOImpl();
        AppUser createdAppUser = appUserDAO.persist(appUserData);

        // Expected:
        AppUser foundAppUser = appUserDAO.findByUsername(createdAppUser.getUsername());

        // Verify: Check that the found app user is not null and matches the created app user.
        assertNotNull(foundAppUser);
        assertEquals(createdAppUser, foundAppUser);
    }

    @Test
    @DisplayName("Should return empty when no app user exists with the given username")
    void findByUsernameAppUserReturnsEmptyWhenNotExists() {
        // Scenario: Create an AppUserDAOImpl object
        AppUserDAOImpl appUserDAO = new AppUserDAOImpl();

        // Expected:
        AppUser foundAppUser = appUserDAO.findByUsername("Hugo");

        // Verify: Check that the found app user is null
        assertNull(foundAppUser);
    }

    @Test
    @DisplayName("Should return all app users")
    void findAllAppUserReturnsAllAppUsersWhenTheyExists(){
        // Scenario: Create multiple app user and add them to an AppUserDAOImpl object.
        AppUser appUserData = new AppUser("testUserName", "testPassword", AppRole.ROLE_APP_USER);
        AppUser appUserData2 = new AppUser("testUserName2", "testPassword2", AppRole.ROLE_APP_USER);
        AppUser appUserData3 = new AppUser("testUserName3", "testPassword3", AppRole.ROLE_APP_ADMIN);
        AppUserDAOImpl appUserDAO = new AppUserDAOImpl();
        AppUser createdAppUser = appUserDAO.persist(appUserData);
        AppUser createdAppUser2 = appUserDAO.persist(appUserData2);
        AppUser createdAppUser3 = appUserDAO.persist(appUserData3);

        // Expected;
        Collection<AppUser> users = appUserDAO.findAll();

        // Verify: Check that the collection is not empty, has the size of three and each element matches the created users
        assertFalse(users.isEmpty());
        assertEquals(3, users.size());
        assertTrue(users.contains(createdAppUser));
        assertTrue(users.contains(createdAppUser2));
        assertTrue(users.contains(createdAppUser3));
    }

    @Test
    @DisplayName("Should return empty when no app users exists")
    void findAllAppUserReturnsEmptyWhenNoneExists(){
        // Scenario: Create an AppUserDAOImpl object which remains empty
        AppUserDAOImpl appUserDAO = new AppUserDAOImpl();

        // Expected;
        Collection<AppUser> users = appUserDAO.findAll();

        // Verify: Check that the collection is empty
        assertTrue(users.isEmpty());
    }

    @Test
    @DisplayName("Should remove a specific app user when it exists successfully")
    void removeAppUserSuccessfully(){
        // Scenario: Create AppUser object, AppUserDAOImpl object then add the AppUser object to the AppUserDAOImpl object
        AppUser appUserData = new AppUser("testUserName", "testPassword", AppRole.ROLE_APP_USER);
        AppUserDAOImpl appUserDAO = new AppUserDAOImpl();
        AppUser createdAppUser = appUserDAO.persist(appUserData);

        // Expected:
        appUserDAO.remove(createdAppUser.getUsername());
        Collection<AppUser> users = appUserDAO.findAll();

        // Verify: Check that the collection is empty
        assertTrue(users.isEmpty());
    }
}
