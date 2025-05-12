package se.lexicon.Data.Impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Model.Person;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOImplTest {

    @Test
    @DisplayName("Should save/persist a person successfully")
    void persistPersonSuccessfully(){
        // Scenario: Create an object of the person class
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");

        // Expected:
        PersonDAOImpl personDAO = new PersonDAOImpl();
        Person createdPerson = personDAO.persist(personData);

        // Verify: Check created person matches original input
        assertEquals(personData, createdPerson);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException because person object is null")
    void persistAppUserWithNullObjectThrowException(){
        // Scenario:

        // Expected:
        PersonDAOImpl personDAO = new PersonDAOImpl();
        String exceptionMessage = "Error: Person object can't be null!";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> personDAO.persist(null));
        String actualExceptionMessage = exception.getMessage();

        // Verify: Check that the exception message is correct
        assertEquals(exceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Should find a person by id when the person exists")
    void findByIDPersonReturnsWhenExists() {
        // Scenario: Create Person object, PersonDAOImpl object then add the person object to the PersonDAOImpl object
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        PersonDAOImpl personDAO = new PersonDAOImpl();
        Person createdPerson = personDAO.persist(personData);

        // Expected:
        Person foundPerson = personDAO.findById(personData.getId());

        // Verify: Check that the found person is not null and matches the created person.
        assertNotNull(foundPerson);
        assertEquals(createdPerson, foundPerson);
    }

    @Test
    @DisplayName("Should return empty when no person exists with the given id")
    void findByIDPersonReturnsEmptyWhenNotExists() {
        // Scenario: Create a PersonDAOImpl object
        PersonDAOImpl personDAO = new PersonDAOImpl();

        // Expected:
        Person foundPerson = personDAO.findById(1000);

        // Verify: Check that the found person is null
        assertNull(foundPerson);
    }

    @Test
    @DisplayName("Should find a person by email when the person exists")
    void findByEmailPersonReturnsWhenExists() {
        // Scenario: Create Person object, PersonDAOImpl object then add the person object to the PersonDAOImpl object
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        PersonDAOImpl personDAO = new PersonDAOImpl();
        Person createdPerson = personDAO.persist(personData);

        // Expected:
        Person foundPerson = personDAO.findByEmail(personData.getEmail());

        // Verify: Check that the found person is not null and matches the created person.
        assertNotNull(foundPerson);
        assertEquals(createdPerson, foundPerson);
    }

    @Test
    @DisplayName("Should return empty when no person exists with the given email")
    void findByEmailPersonReturnsEmptyWhenNotExists() {
        // Scenario: Create a PersonDAOImpl object
        PersonDAOImpl personDAO = new PersonDAOImpl();

        // Expected:
        Person foundPerson = personDAO.findByEmail("Bambi@test.se");

        // Verify: Check that the found person is null
        assertNull(foundPerson);
    }

    @Test
    @DisplayName("Should return all persons")
    void findAllPersonsReturnsAllPersonsWhenTheyExists(){
        // Scenario: Create multiple persons and add them to a PersonDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        PersonDAOImpl personDAO = new PersonDAOImpl();
        Person createdPerson = personDAO.persist(personData);
        Person createdPerson2 = personDAO.persist(personData2);
        Person createdPerson3 = personDAO.persist(personData3);

        // Expected;
        Collection<Person> users = personDAO.findAll();

        // Verify: Check that the collection is not empty, has the size of three and each element matches the created persons
        assertFalse(users.isEmpty());
        assertEquals(3, users.size());
        assertTrue(users.contains(createdPerson));
        assertTrue(users.contains(createdPerson2));
        assertTrue(users.contains(createdPerson3));
    }

    @Test
    @DisplayName("Should return empty when no persons exists")
    void findAllPersonsReturnsEmptyWhenNoneExists(){
        // Scenario: Create a PersonDAOImpl object which remains empty
        PersonDAOImpl personDAO = new PersonDAOImpl();

        // Expected;
        Collection<Person> users = personDAO.findAll();

        // Verify: Check that the collection is empty
        assertTrue(users.isEmpty());
    }

    @Test
    @DisplayName("Should remove a specific person when it exists successfully")
    void removePersonSuccessfully(){
        // Scenario: Create Person object, PersonDAOImpl object then add the Person object to the PersonDAOImpl object
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        PersonDAOImpl personDAO = new PersonDAOImpl();
        Person createdPerson = personDAO.persist(personData);

        // Expected:
        personDAO.remove(createdPerson.getId());
        Collection<Person> users = personDAO.findAll();

        // Verify: Check that the collection is empty
        assertTrue(users.isEmpty());
    }
}
