package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    // --------------------------constructor
    @Test
    public void testConstructorSuccessSentInData() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expectedFName = "Dennis";
        String expectedLName = "Olsen";
        String expectedEmail = "dOlsen@gmail.com";

        // Actual:
        String actualFName = person.getFirstName();
        String actualLName = person.getLastName();
        String actualEmail = person.getEmail();

        // Verify the result:
        Assertions.assertEquals(expectedFName, actualFName);
        Assertions.assertEquals(expectedLName, actualLName);
        Assertions.assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void testConstructor_SentInNullForFirstName_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "FName should not be null or empty";

        // Actual:
        try{
            Person person = new Person(1, null, "Olsen", "dOlsen@gmail.com");
        }
        catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testConstructor_SentInNullForLastName_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "LName should not be null or empty";

        // Actual:
        try{
            Person person = new Person(1, "Dennis", null, "dOlsen@gmail.com");
        }
        catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testConstructor_SentInNullForEmail_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "Email should not be null or empty";

        // Actual:
        try{
            Person person = new Person(1, "Dennis", "Olsen", null);
        }
        catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getId
    @Test
    public void testGetIdSuccess() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        int expected = 1;

        // Actual:
        int actual = person.getId();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getFirstName
    @Test
    public void testGetFirstNameSuccess() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expected = "Dennis";

        // Actual:
        String actual = person.getFirstName();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setFirstName
    @Test
    public void testSetFirstNameSuccess() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newName = "John";

        // Expected:
        String expected = "John";

        // Actual:
        person.setFirstName(newName);
        String actual = person.getFirstName();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetFirstName_SentInNull_ThrowException() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newFirstName = null;

        // Expected:
        String expected = "FName should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setFirstName(newFirstName));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetFirstName_SentInEmptyString_ThrowException() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newFirstName = " ";

        // Expected:
        String expected = "FName should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setFirstName(newFirstName));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getLastName
    @Test
    public void testGetLastNameSuccess() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expected = "Olsen";

        // Actual:
        String actual = person.getLastName();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setLastName
    @Test
    public void testSetLastNameSuccess() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newName = "Bengtsson";

        // Expected:
        String expected = "Bengtsson";

        // Actual:
        person.setLastName(newName);
        String actual = person.getLastName();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetLastName_SentInNull_ThrowException() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newLastName = null;

        // Expected:
        String expected = "LName should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setLastName(newLastName));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetLastName_SentInEmptyString_ThrowException() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newLastName = " ";

        // Expected:
        String expected = "LName should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setLastName(newLastName));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getEmail
    @Test
    public void testGetEmailSuccess() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expected = "dOlsen@gmail.com";

        // Actual:
        String actual = person.getEmail();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setEmail
    @Test
    public void testSetEmailSuccess() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newEMail = "d89Olsen@gmail.com";

        // Expected:
        String expected = "d89Olsen@gmail.com";

        // Actual:
        person.setEmail(newEMail);
        String actual = person.getEmail();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetEmail_SentInNull_ThrowException() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newEmail = null;

        // Expected:
        String expected = "Email should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setEmail(newEmail));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetEmail_SentInEmptyString_ThrowException() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newEmail = " ";

        // Expected:
        String expected = "Email should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setEmail(newEmail));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getSummary
    @Test
    public void testGetSummarySuccess() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expected = "id: 1, name: Dennis Olsen, email: dOlsen@gmail.com";

        // Actual:
        String actual = person.getSummary();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }
}
