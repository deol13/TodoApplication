package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TodoItemTaskTest {

    // --------------------------constructor
    @Test
    public void testConstructor_SentInCorrectData_Success() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        boolean expectedAssigned = true;
        TodoItem expectedTodoItem = todoItem;
        Person expectedAssignee = assignee;

        // Actual:
        boolean actualAssigned = todoItemTask.isAssigned();
        TodoItem actualTodoItem = todoItemTask.getTodoItem();
        Person actualAssignee = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expectedAssigned, actualAssigned);
        Assertions.assertEquals(expectedTodoItem, actualTodoItem);
        Assertions.assertEquals(expectedAssignee, actualAssignee);
    }

    @Test
    public void testConstructor_SentInNullForTodoItem_ThrowException(){
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "todoItem should not be null";

        // Actual:
        try{
            Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
            TodoItemTask todoItemTask = new TodoItemTask(1, null, assignee);
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
    public void testIsAssigned_AssigneeExist_ReturnTrue() {
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
    public void testIsAssigned_NoAssigneeExist_ReturnFalse() {
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

    //---------------------------Assigned
    @Test
    public void testAssigned_ObjectCreatedWithAssignee_True() {
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
    public void testSetAssignee_ObjectCreatedWithoutAssignee_False() {
        // Scenario:
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, null);

        // Expected:
        boolean expected = false;

        // Actual:
        boolean actual = todoItemTask.isAssigned();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Start without assignee then assign a assignee which turns assigned from false to true")
    public void testAssigned_SetAssignee_AssignedTrue() {
        // Scenario:
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, null);

        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");

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

    // --------------------------getTodoItem
    @Test
    public void testGetTodoItem_ReturnCorrectData_Success() {
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
    public void testSetTodoItem_SentInTodoItem_Success() {
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
    public void testSetTodoItem_SentInNull_ThrowException() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);
        TodoItem newTodoItem = null;

        // Expected:
        String expected = "todoItem should not be null";


        // Actual:
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> todoItemTask.setTodoItem(newTodoItem));
        String actual = exception.getMessage();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getAssignee
    @Test
    public void testGetAssignee_ReturnCorrectData_Success() {
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
    public void testSetAssignee_SentInAssignee_Success() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        Person expected = new Person(2, "Johan", "Bengtsson", "JBengtsson@gmail.com");

        // Actual:
        todoItemTask.setAssignee(expected);
        Person actual = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetAssignee_SentInNull_AssigneeIsNowNull() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        Person expected = null;

        // Actual:
        todoItemTask.setAssignee(null);
        Person actual = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------getSummary
    @Test
    public void testGetSummary_Success() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        String expected = "id: 1, assigned: true, todoItem: Lunch menu, assignee: Dennis Olsen";

        // Actual:
        String actual = todoItemTask.getSummary();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }
}
