package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Model.Person;
import se.lexicon.Model.TodoItem;
import se.lexicon.Model.TodoItemTask;
import se.lexicon.Sequencers.TodoItemTaskIdSequencer;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTaskTest {

    // --------------------------constructor
    @Test
    public void testConstructor_SentInCorrectData_Success() {
        // Scenario:
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

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
            Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
            TodoItemTask todoItemTask = new TodoItemTask(null, assignee);
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
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        // Get the current id and tmp store it then switch to a specific id for this test.
        int currentId = TodoItemTaskIdSequencer.getCurrentId();
        TodoItemTaskIdSequencer.setCurrentId(99);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

        // Expected:
        int expected = 100;

        // Actual:
        int actual = todoItemTask.getId();

        // Verify the result:
        Assertions.assertEquals(expected, actual);

        TodoItemTaskIdSequencer.setCurrentId(currentId);
    }

    // --------------------------isAssigned
    @Test
    public void testIsAssigned_AssigneeExist_ReturnTrue() {
        // Scenario:
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

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
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, null);

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
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

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
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, null);

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
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, null);

        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");

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
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

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
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

        // Expected:
        TodoItem expected = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);

        // Actual:
        todoItemTask.setTodoItem(expected);
        TodoItem actual = todoItemTask.getTodoItem();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTodoItem_SentInNull_ThrowException() {
        // Scenario:
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);
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
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

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
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

        // Expected:
        Person expected = new Person("Johan", "Bengtsson", "JBengtsson@gmail.com");

        // Actual:
        todoItemTask.setAssignee(expected);
        Person actual = todoItemTask.getAssignee();

        // Verify the result:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetAssignee_SentInNull_AssigneeIsNowNull() {
        // Scenario:
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

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
        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        // Get the current id and tmp store it then switch to a specific id for this test.
        int currentId = TodoItemTaskIdSequencer.getCurrentId();
        TodoItemTaskIdSequencer.setCurrentId(98);
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, assignee);

        // Expected:
        String expected = "TodoItemTask ID: 99" +
                "\nAssigned: true" +
                "\nTodoItem: " +
                todoItem.toString();

        // Actual:
        String actual = todoItemTask.toString();
        // Switch the id back

        // Verify the result:
        Assertions.assertEquals(expected, actual);

        TodoItemTaskIdSequencer.setCurrentId(currentId);
    }

    // --------------------------equal: Person object isn't checked.
    @Test
    public void testEquals_SecondObjectIsNull_ReturnFalse() {
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem, null);
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
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem, null);
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
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem, null);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem, null);
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
        int currentId = TodoItemTaskIdSequencer.getCurrentId();
        TodoItemTaskIdSequencer.setCurrentId(88);

        Person assignee = new Person("Dennis", "Olsen", "dOlsen@gmail.com");
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, assignee);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem, assignee);
        TodoItemTaskIdSequencer.setCurrentId(88);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem, null);
        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = todoItemTask1.equals(todoItemTask2);

        // Verify the result
        assertFalse(actual);

        TodoItemTaskIdSequencer.setCurrentId(currentId);
    }

    @Test
    @DisplayName("Second object is of the same class but do not contain the same last name.")
    public void testEquals_TodoItemNotTheSame_ReturnFalse() {
        int currentId = TodoItemTaskIdSequencer.getCurrentId();
        TodoItemTaskIdSequencer.setCurrentId(89);

        TodoItem todoItem1 = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem todoItem2 = new TodoItem("Shoe Repair", "Repair shoesk", LocalDate.now().plusWeeks(2), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem1, null);
        TodoItemTaskIdSequencer.setCurrentId(89);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem2, null);

        // Expected:
        //boolean expected = false;

        // Actual:
        boolean actual = todoItemTask1.equals(todoItemTask2);

        // Verify the result
        assertFalse(actual);

        TodoItemTaskIdSequencer.setCurrentId(currentId);
    }

    @Test
    @DisplayName("Second object is exactly the same.")
    public void testEquals_BothObjectsAreEqual_ReturnTrue() {
        int currentId = TodoItemTaskIdSequencer.getCurrentId();
        TodoItemTaskIdSequencer.setCurrentId(90);

        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem, null);
        TodoItemTaskIdSequencer.setCurrentId(90);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem, null);

        // Expected:
        //boolean expected = true;

        // Actual:
        boolean actual = todoItemTask1.equals(todoItemTask2);

        // Verify the result
        assertTrue(actual);

        TodoItemTaskIdSequencer.setCurrentId(currentId);
    }

    // --------------------------hashCode: assigned is a boolean and doesn't have a hash value. Person object isn't checked.

    @Test
    public void testHashCode_IdNotTheSame_NotEqual() {
        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem, null);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem, null);

        // Expected:
        int expected = todoItemTask1.hashCode();

        // Actual:
        int actual = todoItemTask2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void testHashCode_TodoItemNotTheSame_NotEqual() {
        int currentId = TodoItemTaskIdSequencer.getCurrentId();
        TodoItemTaskIdSequencer.setCurrentId(91);

        TodoItem todoItem1 = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItem todoItem2 = new TodoItem("Shoe Repair", "Repair shoesk", LocalDate.now().plusWeeks(2), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem1, null);
        TodoItemTaskIdSequencer.setCurrentId(91);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem2, null);

        // Expected:
        int expected = todoItemTask1.hashCode();

        // Actual:
        int actual = todoItemTask2.hashCode();

        // Verify the result
        Assertions.assertNotEquals(expected, actual);

        TodoItemTaskIdSequencer.setCurrentId(currentId);
    }

    @Test
    public void testHashCode_SameObjects_Equal() {
        int currentId = TodoItemTaskIdSequencer.getCurrentId();
        TodoItemTaskIdSequencer.setCurrentId(115);

        TodoItem todoItem = new TodoItem("Lunch menu", "Make the lunch menu for the week", LocalDate.now().plusWeeks(1), false, null);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem, null);
        TodoItemTaskIdSequencer.setCurrentId(115);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem, null);

        // Expected:
        int expected = todoItemTask1.hashCode();

        // Actual:
        int actual = todoItemTask2.hashCode();

        // Verify the result
        Assertions.assertEquals(expected, actual);

        TodoItemTaskIdSequencer.setCurrentId(currentId);
    }
}
