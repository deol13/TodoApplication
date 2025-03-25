package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TodoItemTest {

    // --------------------------constructor
    @Test
    public void testConstructorSuccessSentInData() {
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

    // --------------------------getId
    @Test
    public void testGetIdSuccess() {
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
    public void testGetTitleSuccess() {
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
    public void testSetTitleSuccessNewTitle() {
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
    public void testGetTaskDescriptionSuccess() {
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
    public void testSetTaskDescriptionSuccessNewString() {
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
    public void testSetTaskDescriptionSuccessNull() {
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
    public void testGetDeadlineSuccess() {
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
    public void testSetDeadlineSuccessNewDeadline() {
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
    public void testIsDoneSuccessStartWithFalse() {
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
    public void testIsDoneSuccessStartWithTrue() {
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
    public void testSetDoneStartWithFalseSetToTrue() {
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
    public void testSetDoneStartWithTrueSetToFalse() {
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
    public void testGetCreatorSuccessStartWithACreator() {
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
    public void testGetCreatorSuccessStartWithNull() {
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
    public void testSetCreatorChangeCreator() {
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
    public void testSetCreatorStartWithNullChangeCreator() {
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
    public void testSetCreatorChangeToNull() {
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
    public void testIsOverdueNotOverdue() {
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
    public void testIsOverdueOverdue() {
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
    public void testIsOverdueSameDayNotOverdue() {
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
    public void testGetSummary() {
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
