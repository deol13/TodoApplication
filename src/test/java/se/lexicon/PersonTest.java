package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {
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
    public void testSetFirstNameFailureNullSent() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newName = null;

        // Expected:
        String expected = "Dennis";

        // Actual:
        person.setFirstName(newName);
        String actual = person.getFirstName();

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
    public void testSetLastNameFailureNullSent() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newName = null;

        // Expected:
        String expected = "Olsen";

        // Actual:
        person.setLastName(newName);
        String actual = person.getLastName();

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
    public void testSetEmailFailureNullSent() {
        // Scenario:
        Person person = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        String newEMail = null;

        // Expected:
        String expected = "dOlsen@gmail.com";

        // Actual:
        person.setEmail(newEMail);
        String actual = person.getEmail();

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
