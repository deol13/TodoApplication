package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Model.Person;
import se.lexicon.Model.TodoItem;
import se.lexicon.Model.TodoItemTask;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testConstructor_SentInNullForTodoItem_ThrowException() {
        // Scenario:
        String actual = "";

        // Expected:
        String expected = "todoItem should not be null";

        // Actual:
        try {
            Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
            TodoItemTask todoItemTask = new TodoItemTask(1, null, assignee);
        } catch (IllegalArgumentException exception) {
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

    // --------------------------toString
    @Test
    public void testToString_Success() {
        // Scenario:
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        // Expected:
        String expected = "TodoItemTask ID: 1\nAssigned: true\nTodoItem: " + todoItem.toString();

        // Actual:
        String actual = todoItemTask.toString();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    // --------------------------equal: Person object isn't checked.
    @Test
    public void testEquals_SecondObjectIsNull_ReturnFalse() {
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(1, todoItem, null);
        TodoItemTask todoItemTask2 = null;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = todoItemTask1.equals(todoItemTask2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is not null but not of the same class")
    public void testEquals_NotTheSameClass_ReturnFalse() {
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(1, todoItem, null);
        int secondObject = 2;

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = todoItemTask1.equals(secondObject);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same id.")
    public void testEquals_IdNotTheSame_ReturnFalse() {
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(1, todoItem, null);
        TodoItemTask todoItemTask2 = new TodoItemTask(2, todoItem, null);
        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = todoItemTask1.equals(todoItemTask2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same first name.")
    public void testEquals_AssignedNotTheSame_ReturnFalse() {
        Person assignee = new Person(1, "Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask1 = new TodoItemTask(1, todoItem, assignee);
        TodoItemTask todoItemTask2 = new TodoItemTask(1, todoItem, null);
        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = todoItemTask1.equals(todoItemTask2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same last name.")
    public void testEquals_TodoItemNotTheSame_ReturnFalse() {
        TodoItem todoItem1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem todoItem2 = new TodoItem(2, "Shoe Repair", "Repair shoesk", LocalDate.now().plusWeeks(2), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(1, todoItem1, null);
        TodoItemTask todoItemTask2 = new TodoItemTask(1, todoItem2, null);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = todoItemTask1.equals(todoItemTask2);

        // Verify the result
        assertFalse(actual);
    }

    @Test
    @DisplayName("Second object is exactly the same.")
    public void testEquals_BothObjectsAreEqual_ReturnTrue() {
        TodoItem todoItemTask1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem todoItemTask2 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);

        // Expected:
        //boolean expected = true;

        // Actual:
        boolean actual = todoItemTask1.equals(todoItemTask2);

        // Verify the result
        assertTrue(actual);
    }

    // --------------------------hashCode: assigned is a boolean and doesn't have a hash value. Person object isn't checked.

    @Test
    public void testHashCode_IdNotTheSame_NotEqual() {
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(1, todoItem, null);
        TodoItemTask todoItemTask2 = new TodoItemTask(2, todoItem, null);

        // Expected:
        int expected = todoItemTask1.hashCode();

        // Actual:
        int actual = todoItemTask2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_TodoItemNotTheSame_NotEqual() {
        TodoItem todoItem1 = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem todoItem2 = new TodoItem(2, "Shoe Repair", "Repair shoesk", LocalDate.now().plusWeeks(2), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(1, todoItem1, null);
        TodoItemTask todoItemTask2 = new TodoItemTask(1, todoItem2, null);

        // Expected:
        int expected = todoItemTask1.hashCode();

        // Actual:
        int actual = todoItemTask2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_SameObjects_Equal() {
        TodoItem todoItem = new TodoItem(1, "Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(1, todoItem, null);
        TodoItemTask todoItemTask2 = new TodoItemTask(1, todoItem, null);

        // Expected:
        int expected = todoItemTask1.hashCode();

        // Actual:
        int actual = todoItemTask2.hashCode();

        // Verify the result
        Assertions.assertEquals(expected, actual);
    }
}
