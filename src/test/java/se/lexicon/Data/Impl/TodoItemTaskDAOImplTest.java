package se.lexicon.Data.Impl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Model.Person;
import se.lexicon.Model.TodoItem;
import se.lexicon.Model.TodoItemTask;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTaskDAOImplTest {

    @Test
    @DisplayName("Should save/persist a TodoItemTask successfully")
    void persistTodoItemSuccessfully(){
        // Scenario: Create an object of the todoItemTask class with a TodoItem and Person object
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);

        // Expected:
        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);

        // Verify: Check created todoItemTask matches original input
        assertEquals(todoItemTaskData, createdTodoItemTask);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException because todoItemTask object is null")
    void persistAppUserWithNullObjectThrowException(){
        // Scenario:

        // Expected:
        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        String exceptionMessage = "Error: todoItemTask object can't be null!";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> todoItemTaskDAO.persist(null));
        String actualExceptionMessage = exception.getMessage();

        // Verify: Check that the exception message is correct
        assertEquals(exceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Should find a todoItemTask by id when the todoItemTask exists")
    void findByIDTodoItemTaskReturnsWhenExists() {
        // Scenario: Create TodoItemTask object with a TodoItem and Person object, a TodoItemTaskDAOImpl object then add the todoItemTask object to the TodoItemTaskDAOImpl object
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);
        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);

        // Expected:
        TodoItemTask foundTodoItemTask = todoItemTaskDAO.findById(todoItemTaskData.getId());

        // Verify: Check that the found todoItemTask is not null and matches the created todoItemTask.
        assertNotNull(foundTodoItemTask);
        assertEquals(createdTodoItemTask, foundTodoItemTask);
    }

    @Test
    @DisplayName("Should return empty when no todoItemTask exists with the given id")
    void findByIDTodoItemTaskReturnsEmptyWhenNotExists() {
        // Scenario: Create an TodoItemTaskDAOImpl object
        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();

        // Expected:
        TodoItemTask foundTodoItem = todoItemTaskDAO.findById(1000);

        // Verify: Check that the found todoItemTask is null
        assertNull(foundTodoItem);
    }

    @Test
    @DisplayName("Should return all todoItemTasks with the an assignee exists")
    void findByAssignedStatusTodoItemTaskReturnsAllTodoItemTaskWithAnAssigneeWhenTheyExists(){
        // Scenario: Create multiple todoItemTasks with a todoItem and person each then add each todoItemTask to a TodoItemTaskDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title", "Test description2", LocalDate.now().plusWeeks(3), false, null );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);
        TodoItemTask todoItemTaskData2 = new TodoItemTask(todoItemData2, null);
        TodoItemTask todoItemTaskData3 = new TodoItemTask(todoItemData3, personData3);

        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);
        TodoItemTask createdTodoItemTask2 = todoItemTaskDAO.persist(todoItemTaskData2);
        TodoItemTask createdTodoItemTask3 = todoItemTaskDAO.persist(todoItemTaskData3);

        // Expected;
        Collection<TodoItemTask> todoItemTasks = todoItemTaskDAO.findByAssignedStatus(true);

        // Verify: Check that the collection is not empty, has the size of two and each element matches the created todoItemTasks
        assertFalse(todoItemTasks.isEmpty());
        assertEquals(2, todoItemTasks.size());
        assertTrue(todoItemTasks.contains(createdTodoItemTask));
        assertTrue(todoItemTasks.contains(createdTodoItemTask3));
    }

    @Test
    @DisplayName("Should return all todoItemTasks with no assignee exists")
    void findByAssignedStatusTodoItemTaskReturnsAllTodoItemTaskWithNoAssigneeWhenTheyExists(){
        // Scenario: Create multiple todoItemTasks with a todoItem and person each then add each todoItemTask object to a TodoItemTaskDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title", "Test description2", LocalDate.now().plusWeeks(3), false,null );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);
        TodoItemTask todoItemTaskData2 = new TodoItemTask(todoItemData2, null);
        TodoItemTask todoItemTaskData3 = new TodoItemTask(todoItemData3, personData3);

        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);
        TodoItemTask createdTodoItemTask2 = todoItemTaskDAO.persist(todoItemTaskData2);
        TodoItemTask createdTodoItemTask3 = todoItemTaskDAO.persist(todoItemTaskData3);

        // Expected;
        Collection<TodoItemTask> todoItemTasks = todoItemTaskDAO.findByAssignedStatus(false);

        // Verify: Check that the collection is not empty, has the size of one and each element matches the created todoItemTasks
        assertFalse(todoItemTasks.isEmpty());
        assertEquals(1, todoItemTasks.size());
        assertTrue(todoItemTasks.contains(createdTodoItemTask2));
    }

    @Test
    @DisplayName("Should return empty when no todoItemTasks with the specified Assigned status exists")
    void findByAssignedStatusIDTodoItemTasksReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemTaskDAOImpl object with one todoItemTask with a different status
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false, personData );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);

        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);

        // Expected;
        Collection<TodoItemTask> todoItemTasks = todoItemTaskDAO.findByAssignedStatus(false);

        // Verify: Check that the collection is empty
        assertTrue(todoItemTasks.isEmpty());
    }

    @Test
    @DisplayName("Should return all todoItemTasks with the specified person id exists")
    void findAllByPersonIDTodoItemTasksReturnsAllTodoItemTasksWhenTheyExists(){
        // Scenario: Create multiple todoItemTasks with a todoItem and person each then add each todoItemTask object to a TodoItemTaskDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);
        TodoItemTask todoItemTaskData2 = new TodoItemTask(todoItemData2, personData2);
        TodoItemTask todoItemTaskData3 = new TodoItemTask(todoItemData3, personData3);

        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);
        TodoItemTask createdTodoItemTask2 = todoItemTaskDAO.persist(todoItemTaskData2);
        TodoItemTask createdTodoItemTask3 = todoItemTaskDAO.persist(todoItemTaskData3);

        // Expected;
        Collection<TodoItemTask> todoItemTasks = todoItemTaskDAO.findByPersonId(personData.getId());

        // Verify: Check that the collection is not empty, has the size of one and each element matches the created todoItemTasks
        assertFalse(todoItemTasks.isEmpty());
        assertEquals(1, todoItemTasks.size());
        assertTrue(todoItemTasks.contains(createdTodoItemTask));
    }

    @Test
    @DisplayName("Should return empty when no todoItemTasks with the specified person id exists")
    void findAllByPersonIDTodoItemTasksReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemTaskDAOImpl object with one todoItem with a different person id
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false, personData );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);

        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);

        // Expected;
        Collection<TodoItemTask> todoItemTasks = todoItemTaskDAO.findByPersonId(1000);

        // Verify: Check that the collection is empty
        assertTrue(todoItemTasks.isEmpty());
    }
    
    @Test
    @DisplayName("Should return all todoItemTasks")
    void findAllTodoItemTasksReturnsAllTodoItemsWhenTheyExists(){
        // Scenario: Create multiple todoItemTasks with a todoItem and person each then add each todoItemTask to a TodoItemTaskDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title2", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);
        TodoItemTask todoItemTaskData2 = new TodoItemTask(todoItemData2, personData2);
        TodoItemTask todoItemTaskData3 = new TodoItemTask(todoItemData3, personData3);

        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);
        TodoItemTask createdTodoItemTask2 = todoItemTaskDAO.persist(todoItemTaskData2);
        TodoItemTask createdTodoItemTask3 = todoItemTaskDAO.persist(todoItemTaskData3);

        // Expected;
        Collection<TodoItemTask> todoItemTasks = todoItemTaskDAO.findAll();

        // Verify: Check that the collection is not empty, has the size of three and each element matches the created todoItemTasks
        assertFalse(todoItemTasks.isEmpty());
        assertEquals(3, todoItemTasks.size());
        assertTrue(todoItemTasks.contains(createdTodoItemTask));
        assertTrue(todoItemTasks.contains(createdTodoItemTask2));
        assertTrue(todoItemTasks.contains(createdTodoItemTask3));
    }

    @Test
    @DisplayName("Should return empty when no todoItemTasks exists")
    void findAllTodoItemTasksReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemTaskDAOImpl object which remains empty
        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();

        // Expected;
        Collection<TodoItemTask> todoItemTasks = todoItemTaskDAO.findAll();

        // Verify: Check that the collection is empty
        assertTrue(todoItemTasks.isEmpty());
    }

    @Test
    @DisplayName("Should remove a specific todoItemTask when it exists successfully")
    void removeTodoItemTaskSuccessfully(){
        // Scenario: Create TodoItem object with a todoItem and person object, a TodoItemTaskDAOImpl object then add the TodoItem object to the TodoItemTaskDAOImpl object
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItemTask todoItemTaskData = new TodoItemTask(todoItemData, personData);

        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        TodoItemTask createdTodoItemTask = todoItemTaskDAO.persist(todoItemTaskData);

        // Expected:
        todoItemTaskDAO.remove(createdTodoItemTask.getId());
        Collection<TodoItemTask> todoItemTasks = todoItemTaskDAO.findAll();

        // Verify: Check that the collection is empty
        assertTrue(todoItemTasks.isEmpty());
    }
}
