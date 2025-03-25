package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoItemTest {
    //TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, person)TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, person)
    // --------------------------getId
    @Test
    public void testGetIdSuccess() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        int expected = 1;

        // Actual:
        int actual = todoItem.getId();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getTitle
    @Test
    public void testGetTitleSuccess() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Lunch menu";

        // Actual:
        String actual = todoItem.getTitle();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setTitle
    @Test
    public void testSetTitleSuccessNewTitle() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Take out the garbage";

        // Actual:
        todoItem.setTitle(expected);
        String actual = todoItem.getTitle();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTitleFailureSentInNull() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Lunch menu";

        // Actual:
        todoItem.setTitle("");
        String actual = todoItem.getTitle();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTitleFailureSentInEmpty() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Lunch menu";

        // Actual:
        todoItem.setTitle(null);
        String actual = todoItem.getTitle();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getTaskDescription
    @Test
    public void testGetTaskDescriptionSuccess() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Make the lunch menu for the week";

        // Actual:
        String actual = todoItem.getTaskDescription();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setTaskDescription
    @Test
    public void testSetTaskDescriptionSuccessNewString() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "Two weeks lunch menu";

        // Actual:
        todoItem.setTaskDescription(expected);
        String actual = todoItem.getTaskDescription();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTaskDescriptionSuccessNull() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = null;

        // Actual:
        todoItem.setTaskDescription(expected);
        String actual = todoItem.getTaskDescription();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getDeadLine
    @Test
    public void testGetDeadlineSuccess() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        LocalDate expected = LocalDate.now().plusWeeks(1);

        // Actual:
        todoItem.setDeadLine(expected);
        LocalDate actual = todoItem.getDeadLine();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setDeadLine
    @Test
    public void testSetDeadlineSuccessNewDeadline() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        LocalDate expected = LocalDate.now().plusWeeks(2);

        // Actual:
        todoItem.setDeadLine(expected);
        LocalDate actual = todoItem.getDeadLine();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetDeadlineFailureSentInNull() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        LocalDate expected = LocalDate.now().plusWeeks(1);

        // Actual:
        todoItem.setDeadLine(null);
        LocalDate actual = todoItem.getDeadLine();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


    // --------------------------isDone
    @Test
    public void testIsDoneSuccessStartWithFalse() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        boolean expected = false;

        // Actual:
        boolean actual = todoItem.isDone();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsDoneSuccessStartWithTrue() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), true, creator);

        // Expected:
        boolean expected = true;

        // Actual:
        boolean actual = todoItem.isDone();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setDone
    @Test
    public void testSetDoneStartWithFalseSetToTrue() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        boolean expected = true;

        // Actual:
        todoItem.setDone(expected);
        boolean actual = todoItem.isDone();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetDoneStartWithTrueSetToFalse() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), true, creator);

        // Expected:
        boolean expected = false;

        // Actual:
        todoItem.setDone(expected);
        boolean actual = todoItem.isDone();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


    // --------------------------getCreator
    @Test
    public void testGetCreatorSuccessStartWithACreator() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        Person expected = creator;

        // Actual:
        Person actual = todoItem.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCreatorSuccessStartWithNull() {
        // Scenario:
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        Person expected = null;

        // Actual:
        Person actual = todoItem.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


    // --------------------------setCreator
    @Test
    public void testSetCreatorChangeCreator() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        Person expected = new Person(1, "Johan", "Myrstad", "JohanM@gmail.com");

        // Actual:
        todoItem.setCreator(expected);
        Person actual = todoItem.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCreatorStartWithNullChangeCreator() {
        // Scenario:
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        Person expected = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

        // Actual:
        todoItem.setCreator(expected);
        Person actual = todoItem.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCreatorChangeToNull() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        Person expected = null;

        // Actual:
        todoItem.setCreator(expected);
        Person actual = todoItem.getCreator();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------isOverdue
    @Test
    public void testIsOverdueNotOverdue() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        boolean expected = false;

        // Actual:
        boolean actual = todoItem.isOverdue();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsOverdueOverdue() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().minusWeeks(1), false, creator);

        // Expected:
        boolean expected = true;

        // Actual:
        boolean actual = todoItem.isOverdue();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsOverdueSameDayNotOverdue() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now(), false, creator);

        // Expected:
        boolean expected = false;

        // Actual:
        boolean actual = todoItem.isOverdue();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


    // --------------------------getSummary
    @Test
    public void testGetSummary() {
        // Scenario:
        Person creator = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, creator);

        // Expected:
        String expected = "id: 1, title: Lunch menu, description: Make the lunch menu for the week" +
                ", deadline: " + LocalDate.now().plusWeeks(1)
                + ", done: false"
                + ", creator: " + creator.getFirstName() + " " + creator.getLastName();

        // Actual:
        String actual = todoItem.getSummary();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }


}
