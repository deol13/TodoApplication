package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

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


    // --------------------------getSummary
    @Test
    public void testGetSummary_Success() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem item = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "id: 1, title: Lunch menu, description: Make the lunch menu for the week" +
                ", deadline: " + LocalDate.now().plusWeeks(1)
                + ", done: false"
                + ", creator: " + creator.getFirstName() + " " + creator.getLastName();

        // Actual:
        String actual = item.getSummary();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


}
