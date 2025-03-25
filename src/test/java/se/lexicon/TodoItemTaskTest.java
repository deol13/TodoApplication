package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoItemTaskTest {

    // --------------------------constructor
    @Test
    public void testConstructorSuccessSentInData(){
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        boolean expectedAssigned = true;
        TodoItem expectedTodoItem = todoItem;
        Person expectedAssignee = assignee;

        // Actual:
        boolean actualAssigned= todoItemTask.isAssigned();
        TodoItem actualTodoItem = todoItemTask.getTodoItem();
        Person actualAssignee  = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expectedAssigned, actualAssigned);
        Assertions.assertEquals(expectedTodoItem, actualTodoItem);
        Assertions.assertEquals(expectedAssignee, actualAssignee);
    }

    //todo: probably shouldn't work like this.
    @Test
    public void testConstructorFailureSentInNull(){
        // Scenario:
        TodoItemTask todoItemTask = new TodoItemTask(1, null, null);

        // Expected:
        boolean expectedAssigned = false;
        TodoItem expectedTodoItem = null;
        Person expectedAssignee = null;

        // Actual:
        boolean actualAssigned= todoItemTask.isAssigned();
        TodoItem actualTodoItem = todoItemTask.getTodoItem();
        Person actualAssignee  = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expectedAssigned, actualAssigned);
        Assertions.assertEquals(expectedTodoItem, actualTodoItem);
        Assertions.assertEquals(expectedAssignee, actualAssignee);
    }

    // --------------------------getId
    @Test
    public void testGetIdSuccess() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        int expected = 1;

        // Actual:
        int actual = todoItemTask.getId();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------isAssigned
    @Test
    public void testIsAssignedTrueSentAssigneeInConstructor() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        boolean expected = true;

        // Actual:
        boolean actual = todoItemTask.isAssigned();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsAssignedFalseWithoutAssignee() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, null);

        // Expected:
        boolean expected = false;

        // Actual:
        boolean actual = todoItemTask.isAssigned();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setAssigned
    @Test
    public void testSetAssignedTrueWithAssignee() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);
        todoItemTask.setAssigned(false);

        // Expected:
        boolean expected = true;

        // Actual:
        todoItemTask.setAssigned(true);
        boolean actual = todoItemTask.isAssigned();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetAssignedTrueWithoutAssignee() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, null);

        // Expected:
        boolean expected = false;

        // Actual:
        todoItemTask.setAssigned(true);
        boolean actual = todoItemTask.isAssigned();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetAssignedFalseWithAssignee() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        boolean expected = false;

        // Actual:
        todoItemTask.setAssigned(false);
        boolean actual = todoItemTask.isAssigned();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getTodoItem
    @Test
    public void testGetTodoItemSuccess() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        TodoItem expected = todoItem;

        // Actual:
        TodoItem actual = todoItemTask.getTodoItem();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setTodoItem
    @Test
    public void testSetTodoItemSuccessSentTodoItem() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        TodoItem expected = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);

        // Actual:
        todoItemTask.setTodoItem(expected);
        TodoItem actual = todoItemTask.getTodoItem();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTodoItemFailureSentNull() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        TodoItem expected = todoItem;

        // Actual:
        todoItemTask.setTodoItem(null);
        TodoItem actual = todoItemTask.getTodoItem();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getAssignee
    @Test
    public void testGetAssigneeSuccess() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        Person expected = assignee;

        // Actual:
        Person actual = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------setAssignee
    @Test
    public void testSetAssigneeSuccessSentInAssignee() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        Person expected = new Person(2, "Johan", "Bengtsson", "JBengtsson@gmail.com");
        ;

        // Actual:
        todoItemTask.setAssignee(expected);
        Person actual = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetAssigneeSuccessSentInNull() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);
        todoItemTask.setAssigned(true);

        // Expected:
        Person expected = null;

        // Actual:
        todoItemTask.setAssignee(null);
        Person actual = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetAssigneeSuccessCheckAssignedIfTrue() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, null);

        // Expected:
        boolean before = todoItemTask.isAssigned();
        boolean expected = true;

        // Actual:
        todoItemTask.setAssignee(assignee);
        boolean actual = todoItemTask.isAssigned();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
        Assertions.assertFalse(before);
    }

    // --------------------------getSummary
    @Test
    public void testGetSummarySuccess() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);
        todoItemTask.setAssigned(true);

        // Expected:
        String expected = "id: 1, assigned: true, todoItem: Lunch menu, assignee: Dennis Olsen";

        // Actual:
        String actual = todoItemTask.getSummary();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }
}
