package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {

    // --------------------------constructor
    @Test
    public void testConstructor_SentInCorrectData_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expectedTitle = "Lunch menu";
        String expectedTaskDes = "Make the lunch menu for the week";
        LocalDate expectedDeadline = LocalDate.now().plusWeeks(1);
        boolean expectedDone = false;
        Person expectedCreator = creator;

        // Actual:
        String actualTitle = item.getTitle();
        String actualTaskDes = item.getTaskDescription();
        LocalDate actualDeadline = item.getDeadLine();
        boolean actualDone = item.isDone();
        Person actualCreator = item.getCreator();

        // Verify the result:
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedTaskDes, actualTaskDes);
        Assertions.assertEquals(expectedDeadline, actualDeadline);
        Assertions.assertEquals(expectedDone, actualDone);
        Assertions.assertEquals(expectedCreator, actualCreator);
    }

    @Test
    public void testConstructor_SentInNullForTitle_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "Title should not be null or empty";

        // Actual:
        try{
            Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
            TodoItem item = new TodoItem(1, null, "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);
        }
        catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testConstructor_SentInNullForDeadline_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "Deadline should not be null";

        // Actual:
        try{
            Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
            TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", null, false, creator);
        }
        catch (IllegalArgumentException exception) {
            actual = exception.getMessage();
        }

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getId
    @Test
    public void testGetId_ReturnCorrectData_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        int expected = 1;

        // Actual:
        int actual = item.getId();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getTitle
    @Test
    public void testGetTitle_ReturnCorrectData_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Lunch menu";

        // Actual:
        String actual = item.getTitle();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setTitle
    @Test
    public void testSetTitle_SentInCorrectData_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Take out the garbage";

        // Actual:
        item.setTitle(expected);
        String actual = item.getTitle();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTitle_SentInNull_ThrowException() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);
        String newTitle = null;

        // Expected:
        String expected = "Title should not be null or empty";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> item.setTitle(newTitle));

        // Actual:
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTitle_SentInEmptyString_ThrowException() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);
        String newTitle = " ";

        // Expected:
        String expected = "Title should not be null or empty";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> item.setTitle(newTitle));

        // Actual:
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getTaskDescription
    @Test
    public void testGetTaskDescription_ReturnCorrectData_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Make the lunch menu for the week";

        // Actual:
        String actual = item.getTaskDescription();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setTaskDescription
    @Test
    public void testSetTaskDescription_SentInCorrectData_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Two weeks lunch menu";

        // Actual:
        item.setTaskDescription(expected);
        String actual = item.getTaskDescription();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTaskDescription_SentInNull_TaskDescriptionNowNull() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = null;

        // Actual:
        item.setTaskDescription(expected);
        String actual = item.getTaskDescription();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getDeadLine
    @Test
    public void testGetDeadline_ReturnCorrectData_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        LocalDate expected = LocalDate.now().plusWeeks(1);

        // Actual:
        item.setDeadLine(expected);
        LocalDate actual = item.getDeadLine();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setDeadLine
    @Test
    public void testSetDeadline_SentInCorrectData_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        LocalDate expected = LocalDate.now().plusWeeks(2);

        // Actual:
        item.setDeadLine(expected);
        LocalDate actual = item.getDeadLine();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetDeadline_SentInNull_ThrowException() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);
        LocalDate newDate = null;

        // Expected:
        String expected = "Deadline should not be null";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> item.setDeadLine(newDate));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


    // --------------------------isDone
    @Test
    public void testIsDoneSuccess_StartWithFalse_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        boolean expected = false;

        // Actual:
        boolean actual = item.isDone();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsDoneSuccess_StartWithTrue_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), true, creator);

        // Expected:
        boolean expected = true;

        // Actual:
        boolean actual = item.isDone();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setDone
    @Test
    public void testSetDone_StartWithFalse_SetToTrue_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        boolean expected = true;

        // Actual:
        item.setDone(expected);
        boolean actual = item.isDone();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetDone_StartWithTrue_SetToFalse_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), true, creator);

        // Expected:
        boolean expected = false;

        // Actual:
        item.setDone(expected);
        boolean actual = item.isDone();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


    // --------------------------getCreator
    @Test
    public void testGetCreator_StartWithACreator_ReturnCreator() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        Person expected = creator;

        // Actual:
        Person actual = item.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCreator_StartWithNullCreator_ReturnNull() {
        // Scenario:
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        Person expected = null;

        // Actual:
        Person actual = item.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


    // --------------------------setCreator
    @Test
    public void testSetCreator_ChangeCreator_ReturnNewCreator() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        Person expected = new Person(1, "Johan", "Myrstad", "JohanM@gmail.com");

        // Actual:
        item.setCreator(expected);
        Person actual = item.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCreator_StartWithNullCreator_ChangeCreator_ReturnNewCreator() {
        // Scenario:
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        Person expected = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

        // Actual:
        item.setCreator(expected);
        Person actual = item.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCreator_ChangeToNull_CreatorIsNowNull() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        Person expected = null;

        // Actual:
        item.setCreator(expected);
        Person actual = item.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------isOverdue
    @Test
    public void testIsOverdue_DeadlineNotNotOverdue() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        boolean expected = false;

        // Actual:
        boolean actual = item.isOverdue();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsOverdue_DeadlineOverdue() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().minusWeeks(1), false, creator);

        // Expected:
        boolean expected = true;

        // Actual:
        boolean actual = item.isOverdue();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsOverdue_SameDay_DeadlineNotOverdue() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now(), false, creator);

        // Expected:
        boolean expected = false;

        // Actual:
        boolean actual = item.isOverdue();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


    // --------------------------toString
    @Test
    public void testToString_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "TodoItem ID: 1" +
                "\nTitle: Lunch menu" +
                "\nTask description: Make the lunch menu for the week" +
                "\nDeadline: "+ LocalDate.now().plusWeeks(1) +
                "\nDone: false";

        // Actual:
        String actual = item.toString();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------equal: Person class isn't checked
    @Test
    public void testEquals_SecondObjectIsNull_ReturnFalse(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = null;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = item1.equals(item2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is not null but not of the same class")
    public void testEquals_NotTheSameClass_ReturnFalse(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        int secondObject = 2;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = item1.equals(secondObject);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same id.")
    public void testEquals_IdNotTheSame_ReturnFalse(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(2, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = item1.equals(item2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same first name.")
    public void testEquals_TitleNotTheSame_ReturnFalse(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Shoe repair", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = item1.equals(item2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same last name.")
    public void testEquals_TaskDescriptionNotTheSame_ReturnFalse(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Lunch menu", "Two weeks menu", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = item1.equals(item2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same email.")
    public void testEquals_DeadLineNotTheSame_ReturnFalse(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(2), false, null);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = item1.equals(item2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same email.")
    public void testEquals_DoneNotTheSame_ReturnFalse(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), true, null);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = item1.equals(item2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is exactly the same.")
    public void testEquals_BothObjectsAreEqual_ReturnTrue(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        //boolean expected = true;

        // Actual:
        boolean actual = item1.equals(item2);

        // Verify the result
        assertTrue(actual);
    }

    // --------------------------hashCode: Done is a boolean and doesn't have a hash value. Person class isn't checked in hashcode.

    @Test
    public void testHashCode_IdNotTheSame_NotEqual(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(2, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        int expected = item1.hashCode();

        // Actual:
        int actual = item2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_TitleNotTheSame_NotEqual(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Shoe repair", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        int expected = item1.hashCode();

        // Actual:
        int actual = item2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_TaskDescriptionNotTheSame_NotEqual(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Lunch menu", "Two weeks of lunch", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        int expected = item1.hashCode();

        // Actual:
        int actual = item2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_DeadlineNotTheSame_NotEqual(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(3), false, null);

        // Expected:
        int expected = item1.hashCode();

        // Actual:
        int actual = item2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_SameObjects_Equal(){
        TodoItem item1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem item2 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        ;
        // Expected:
        int expected = item1.hashCode();

        // Actual:
        int actual = item2.hashCode();

        // Verify the result
        Assertions.assertEquals(expected, actual);
    }
}
