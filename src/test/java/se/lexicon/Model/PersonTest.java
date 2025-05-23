package se.lexicon.Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Sequencers.PersonIdSequencer;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    // --------------------------constructor
    @Test
    public void testConstructor_SentInCorrectData_Success() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expectedFName = "Dennis";
        String expectedLName = "Olsen";
        String expectedEmail = "dOlsen@gmail.com";

        // Actual:
        String actualFName = person.getFirstName();
        String actualLName = person.getLastName();
        String actualEmail = person.getEmail();

        // Verify the result:
        assertEquals(expectedFName, actualFName);
        assertEquals(expectedLName, actualLName);
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void testConstructor_SentInNullForFirstName_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "FName should not be null or empty";

        // Actual:
        try{
            Person person = new Person(null, "Olsen", "dOlsen@gmail.com");
        }
        catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }

        // Verify the result:
        assertEquals(expected, actual);
    }
    @Test
    public void testConstructor_SentInNullForLastName_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "LName should not be null or empty";

        // Actual:
        try{
            Person person = new Person("Dennis", null, "dOlsen@gmail.com");
        }
        catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }

        // Verify the result:
        assertEquals(expected, actual);
    }
    @Test
    public void testConstructor_SentInNullForEmail_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "Email should not be null or empty";

        // Actual:
        try{
            Person person = new Person("Dennis", "Olsen", null);
        }
        catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }

        // Verify the result:
        assertEquals(expected, actual);
    }

    // --------------------------getId
    @Test
    public void testGetId_ReturnCorrectData_Success() {
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(100);

        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        int expected = 101;

        // Actual:
        int actual = person.getId();

        // Verify the result:
        assertEquals(expected, actual);

        PersonIdSequencer.setCurrentId(currentId);
    }

    // --------------------------getFirstName
    @Test
    public void testGetFirstName_ReturnCorrectData_Success() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expected = "Dennis";

        // Actual:
        String actual = person.getFirstName();

        // Verify the result:
        assertEquals(expected, actual);
    }

    // --------------------------setFirstName
    @Test
    public void testSetFirstName_SentInCorrectData_Success() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newName = "John";

        // Expected:
        String expected = "John";

        // Actual:
        person.setFirstName(newName);
        String actual = person.getFirstName();

        // Verify the result:
        assertEquals(expected, actual);
    }

    @Test
    public void testSetFirstName_SentInNull_ThrowException() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newFirstName = null;

        // Expected:
        String expected = "FName should not be null or empty";

        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setFirstName(newFirstName));
        String actual = exception.getMessage();

        // Verify the result:
        assertEquals(expected, actual);
    }

    @Test
    public void testSetFirstName_SentInEmptyString_ThrowException() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newFirstName = " ";

        // Expected:
        String expected = "FName should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setFirstName(newFirstName));
        String actual = exception.getMessage();

        // Verify the result:
        assertEquals(expected, actual);
    }

    // --------------------------getLastName
    @Test
    public void testGetLastName_ReturnCorrectData_Success() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expected = "Olsen";

        // Actual:
        String actual = person.getLastName();

        // Verify the result:
        assertEquals(expected, actual);
    }

    // --------------------------setLastName
    @Test
    public void testSetLastName_SentInCorrectData_Success() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newName = "Bengtsson";

        // Expected:
        String expected = "Bengtsson";

        // Actual:
        person.setLastName(newName);
        String actual = person.getLastName();

        // Verify the result:
        assertEquals(expected, actual);
    }

    @Test
    public void testSetLastName_SentInNull_ThrowException() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newLastName = null;

        // Expected:
        String expected = "LName should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setLastName(newLastName));
        String actual = exception.getMessage();

        // Verify the result:
        assertEquals(expected, actual);
    }

    @Test
    public void testSetLastName_SentInEmptyString_ThrowException() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newLastName = " ";

        // Expected:
        String expected = "LName should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setLastName(newLastName));
        String actual = exception.getMessage();

        // Verify the result:
        assertEquals(expected, actual);
    }

    // --------------------------getEmail
    @Test
    public void testGetEmail_ReturnCorrectData_Success() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expected = "dOlsen@gmail.com";

        // Actual:
        String actual = person.getEmail();

        // Verify the result:
        assertEquals(expected, actual);
    }

    // --------------------------setEmail
    @Test
    public void testSetEmail_SentInCorrectData_Success() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newEMail = "d89Olsen@gmail.com";

        // Expected:
        String expected = "d89Olsen@gmail.com";

        // Actual:
        person.setEmail(newEMail);
        String actual = person.getEmail();

        // Verify the result:
        assertEquals(expected, actual);
    }

    @Test
    public void testSetEmail_SentInNull_ThrowException() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newEmail = null;

        // Expected:
        String expected = "Email should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setEmail(newEmail));
        String actual = exception.getMessage();

        // Verify the result:
        assertEquals(expected, actual);
    }

    @Test
    public void testSetEmail_SentInEmptyString_ThrowException() {
        // Scenario:
        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        String newEmail = " ";

        // Expected:
        String expected = "Email should not be null or empty";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> person.setEmail(newEmail));
        String actual = exception.getMessage();

        // Verify the result:
        assertEquals(expected, actual);
    }

    // --------------------------toString
    @Test
    public void testToString_Success() {
        // Scenario:
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(101);

        Person person = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        String expected = "Person ID: 102\nName: Dennis Olsen\nEmail: dOlsen@gmail.com";

        // Actual:
        String actual = person.toString();

        // Verify the result:
        assertEquals(expected, actual);

        PersonIdSequencer.setCurrentId(currentId);
    }

    // --------------------------equal
    @Test
    public void testEquals_SecondObjectIsNull_ReturnFalse(){
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        Person person2 = null;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = person1.equals(person2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is not null but not of the same class")
    public void testEquals_NotTheSameClass_ReturnFalse(){
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        int secondObject = 2;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = person1.equals(secondObject);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same id.")
    public void testEquals_IdNotTheSame_ReturnFalse(){
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        Person person2 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = person1.equals(person2);

        // Verify the result
        assertFalse(actual);
    }
    @Test
    @DisplayName("Second object is of the same class but do not contain the same first name.")
    public void testEquals_FirstNameNotTheSame_ReturnFalse(){
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(103);

        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        PersonIdSequencer.setCurrentId(103);
        Person person2 = new Person("John", "Olsen", "dOlsen@gmail.com");;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = person1.equals(person2);

        // Verify the result
        assertFalse(actual);

        PersonIdSequencer.setCurrentId(currentId);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same last name.")
    public void testEquals_LastNameNotTheSame_ReturnFalse(){
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(104);
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        PersonIdSequencer.setCurrentId(104);
        Person person2 = new Person("Dennis", "Bengtsson", "dOlsen@gmail.com");;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = person1.equals(person2);

        // Verify the result
        assertFalse(actual);

        PersonIdSequencer.setCurrentId(currentId);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same email.")
    public void testEquals_EmailNotTheSame_ReturnFalse(){
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(105);
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        PersonIdSequencer.setCurrentId(105);
        Person person2 = new Person("Dennis", "Olsen", "Dennis@gmail.com");;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = person1.equals(person2);

        // Verify the result
        assertFalse(actual);

        PersonIdSequencer.setCurrentId(currentId);
    }

    @Test
    @DisplayName("Second object is exactly the same.")
    public void testEquals_BothObjectsAreEqual_ReturnTrue(){
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(106);
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        PersonIdSequencer.setCurrentId(106);
        Person person2 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");;

        // Expected:
        //boolean expected = true;

        // Actual:
        boolean actual = person1.equals(person2);

        // Verify the result
        assertTrue(actual);

        PersonIdSequencer.setCurrentId(currentId);
    }

    // --------------------------hashCode

    @Test
    public void testHashCode_IdNotTheSame_NotEqual(){
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        Person person2 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        int expected = person1.hashCode();

        // Actual:
        int actual = person2.hashCode();

        // Verify the result
        assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_FirstNameNotTheSame_NotEqual(){
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(110);
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        PersonIdSequencer.setCurrentId(110);
        Person person2 = new Person("John", "Olsen", "dOlsen@gmail.com");

        // Expected:
        int expected = person1.hashCode();

        // Actual:
        int actual = person2.hashCode();

        // Verify the result
        assertNotEquals(expected, actual);

        PersonIdSequencer.setCurrentId(currentId);
    }

    @Test
    public void testHashCode_LastNameNotTheSame_NotEqual(){
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(111);
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        PersonIdSequencer.setCurrentId(111);
        Person person2 = new Person("Dennis", "Bengtsson", "dOlsen@gmail.com");

        // Expected:
        int expected = person1.hashCode();

        // Actual:
        int actual = person2.hashCode();

        // Verify the result
        assertNotEquals(expected, actual);

        PersonIdSequencer.setCurrentId(currentId);
    }

    @Test
    public void testHashCode_EmailNotTheSame_NotEqual(){
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(112);
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        PersonIdSequencer.setCurrentId(112);
        Person person2 = new Person("Dennis", "Olsen", "Dennis@gmail.com");

        // Expected:
        int expected = person1.hashCode();

        // Actual:
        int actual = person2.hashCode();

        // Verify the result
        assertNotEquals(expected, actual);
        PersonIdSequencer.setCurrentId(currentId);
    }

    @Test
    public void testHashCode_SameObjects_Equal(){
        int currentId = PersonIdSequencer.getCurrentId();
        PersonIdSequencer.setCurrentId(113);
        Person person1 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        PersonIdSequencer.setCurrentId(113);
        Person person2 = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

        // Expected:
        int expected = person1.hashCode();

        // Actual:
        int actual = person2.hashCode();

        // Verify the result
        assertEquals(expected, actual);

        PersonIdSequencer.setCurrentId(currentId);
    }
}
