package se.lexicon.Data.Impl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Model.Person;
import se.lexicon.Model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemDAOImplTest {

    @Test
    @DisplayName("Should save/persist a TodoItem successfully")
    void persistTodoItemSuccessfully(){
        // Scenario: Create an object of the todoItem class and Person class
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );

        // Expected:
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);

        // Verify: Check created todoItem matches original input
        assertEquals(todoItemData, createdTodoItem);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException because todoItem object is null")
    void persistTodoItemWithNullObjectThrowException(){
        // Scenario:

        // Expected:
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        String exceptionMessage = "Error: todoItem object can't be null!";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> todoItemDAO.persist(null));
        String actualExceptionMessage = exception.getMessage();

        // Verify: Check that the exception message is correct
        assertEquals(exceptionMessage, actualExceptionMessage);
    }

    @Test
    @DisplayName("Should find a todoItem by id when the todoItem exists")
    void findByIDTodoItemReturnsWhenExists() {
        // Scenario: Create TodoItem object with a Person object, a TodoItemDAOImpl object then add the todoItem object to the TodoItemDAOImpl object
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);

        // Expected:
        TodoItem foundTodoItem = todoItemDAO.findById(todoItemData.getId());

        // Verify: Check that the found todoItem is not null and matches the created todoItem.
        assertNotNull(foundTodoItem);
        assertEquals(createdTodoItem, foundTodoItem);
    }

    @Test
    @DisplayName("Should return empty when no todoItem exists with the given id")
    void findByIDTodoItemReturnsEmptyWhenNotExists() {
        // Scenario: Create an TodoItemDAOImpl object
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();

        // Expected:
        TodoItem foundTodoItem = todoItemDAO.findById(1000);

        // Verify: Check that the found todoItem is null
        assertNull(foundTodoItem);
    }

    @Test
    @DisplayName("Should return all todoItems with the false done status exists")
    void findAllByDoneStatusTodoItemsReturnsAllTodoItemWithFALSEDoneStatusWhenTheyExists(){
        // Scenario: Create multiple todoItems with a person each then add them to a TodoItemDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title2", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);
        TodoItem createdTodoItem2 = todoItemDAO.persist(todoItemData2);
        TodoItem createdTodoItem3 = todoItemDAO.persist(todoItemData3);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findAllByDoneStatus(false);

        // Verify: Check that the collection is not empty, has the size of two and each element matches the created todoItems
        assertFalse(todoItems.isEmpty());
        assertEquals(2, todoItems.size());
        assertTrue(todoItems.contains(createdTodoItem));
        assertTrue(todoItems.contains(createdTodoItem2));
    }

    @Test
    @DisplayName("Should return all todoItems with the true done status exists")
    void findAllByDoneStatusTodoItemsReturnsAllTodoItemWithTRUEDoneStatusWhenTheyExists(){
        // Scenario: Create multiple todoItems with a person each then add them to a TodoItemDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title2", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);
        TodoItem createdTodoItem2 = todoItemDAO.persist(todoItemData2);
        TodoItem createdTodoItem3 = todoItemDAO.persist(todoItemData3);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findAllByDoneStatus(true);

        // Verify: Check that the collection is not empty, has the size of one and each element matches the created todoItems
        assertFalse(todoItems.isEmpty());
        assertEquals(1, todoItems.size());
        assertTrue(todoItems.contains(createdTodoItem3));
    }

    @Test
    @DisplayName("Should return empty when no todoItems with the specified done status exists")
    void findAllByDoneStatusTodoItemsReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemDAOImpl object with one todoItem with false done status
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false, null );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findAllByDoneStatus(true);

        // Verify: Check that the collection is empty
        assertTrue(todoItems.isEmpty());
    }

    @Test
    @DisplayName("Should return all todoItems with the specified title exists")
    void findAllByTitleContainsTodoItemsReturnsAllTodoItemWhenTheyExists(){
        // Scenario: Create multiple todoItems with a person each then add them to a TodoItemDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);
        TodoItem createdTodoItem2 = todoItemDAO.persist(todoItemData2);
        TodoItem createdTodoItem3 = todoItemDAO.persist(todoItemData3);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findByTitleContains("Test title");

        // Verify: Check that the collection is not empty, has the size of two and each element matches the created todoItems
        assertFalse(todoItems.isEmpty());
        assertEquals(2, todoItems.size());
        assertTrue(todoItems.contains(createdTodoItem));
        assertTrue(todoItems.contains(createdTodoItem2));
    }

    @Test
    @DisplayName("Should return empty when no todoItems with the specified done status exists")
    void findAllByTitleContainsTodoItemsReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemDAOImpl object which remains with one todoItem with another title
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false, null );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findByTitleContains("Test title2");

        // Verify: Check that the collection is empty
        assertTrue(todoItems.isEmpty());
    }

    @Test
    @DisplayName("Should return all todoItems with the specified person id exists")
    void findAllByPersonIDTodoItemsReturnsAllTodoItemWhenTheyExists(){
        // Scenario: Create multiple todoItems with a person each then add them to a TodoItemDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);
        TodoItem createdTodoItem2 = todoItemDAO.persist(todoItemData2);
        TodoItem createdTodoItem3 = todoItemDAO.persist(todoItemData3);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findByPersonId(personData.getId());

        // Verify: Check that the collection is not empty, has the size of one and each element matches the created todoItems
        assertFalse(todoItems.isEmpty());
        assertEquals(1, todoItems.size());
        assertTrue(todoItems.contains(createdTodoItem));
    }

    @Test
    @DisplayName("Should return empty when no todoItems with the specified person id exists")
    void findAllByPersonIDTodoItemsReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemDAOImpl object which remains with one todoItem with a different person id
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false, personData );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findByPersonId(1000);

        // Verify: Check that the collection is empty
        assertTrue(todoItems.isEmpty());
    }

    @Test
    @DisplayName("Should return all todoItems with the deadline before exists")
    void findAllByDeadlineBeforeTodoItemsReturnsAllTodoItemWhenTheyExists(){
        // Scenario: Create multiple todoItems with a person each then add them to a TodoItemDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);
        TodoItem createdTodoItem2 = todoItemDAO.persist(todoItemData2);
        TodoItem createdTodoItem3 = todoItemDAO.persist(todoItemData3);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findByDeadlineBefore(LocalDate.now());

        // Verify: Check that the collection is not empty, has the size of one and each element matches the created todoItems
        assertFalse(todoItems.isEmpty());
        assertEquals(1, todoItems.size());
        assertTrue(todoItems.contains(createdTodoItem3));
    }

    @Test
    @DisplayName("Should return empty when no todoItems with the deadline before exists")
    void findAllByByDeadlineBeforeTodoItemsReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemDAOImpl object which remains with one todoItem with a deadline after
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false, personData );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findByDeadlineBefore(LocalDate.now());

        // Verify: Check that the collection is empty
        assertTrue(todoItems.isEmpty());
    }

    @Test
    @DisplayName("Should return all todoItems with the deadline after exists")
    void findAllByDeadlineAfterTodoItemsReturnsAllTodoItemWhenTheyExists(){
        // Scenario: Create multiple todoItems with a person each then add them to a TodoItemDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);
        TodoItem createdTodoItem2 = todoItemDAO.persist(todoItemData2);
        TodoItem createdTodoItem3 = todoItemDAO.persist(todoItemData3);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findByDeadlineAfter(LocalDate.now());

        // Verify: Check that the collection is not empty, has the size of two and each element matches the created todoItems
        assertFalse(todoItems.isEmpty());
        assertEquals(2, todoItems.size());
        assertTrue(todoItems.contains(createdTodoItem));
        assertTrue(todoItems.contains(createdTodoItem2));
    }

    @Test
    @DisplayName("Should return empty when no todoItems with the deadline after exists")
    void findAllByByDeadlineAfterTodoItemsReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemDAOImpl object which remains with one todoItem with a deadline after
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().minusWeeks(2), false, personData );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findByDeadlineAfter(LocalDate.now());

        // Verify: Check that the collection is empty
        assertTrue(todoItems.isEmpty());
    }

    @Test
    @DisplayName("Should return all todoItems")
    void findAllTodoItemsReturnsAllTodoItemsWhenTheyExists(){
        // Scenario: Create multiple todoItems with a person each then add them to a TodoItemDAOImpl object.
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        Person personData2 = new Person("testFirstName2", "testLastName2", "test2@email.se");
        Person personData3 = new Person("testFirstName3", "testLastName3", "test3@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItem todoItemData2 = new TodoItem("Test title2", "Test description2", LocalDate.now().plusWeeks(3), false,personData2 );
        TodoItem todoItemData3 = new TodoItem("Test title3", "Test description3", LocalDate.now().minusWeeks(2), true,personData3 );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);
        TodoItem createdTodoItem2 = todoItemDAO.persist(todoItemData2);
        TodoItem createdTodoItem3 = todoItemDAO.persist(todoItemData3);

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findAll();

        // Verify: Check that the collection is not empty, has the size of three and each element matches the created todoItems
        assertFalse(todoItems.isEmpty());
        assertEquals(3, todoItems.size());
        assertTrue(todoItems.contains(createdTodoItem));
        assertTrue(todoItems.contains(createdTodoItem2));
        assertTrue(todoItems.contains(createdTodoItem3));
    }

    @Test
    @DisplayName("Should return empty when no todoItems exists")
    void findAllTodoItemsReturnsEmptyWhenNoneExists(){
        // Scenario: Create an TodoItemDAOImpl object which remains empty
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();

        // Expected;
        Collection<TodoItem> todoItems = todoItemDAO.findAll();

        // Verify: Check that the collection is empty
        assertTrue(todoItems.isEmpty());
    }

    @Test
    @DisplayName("Should remove a specific todoItem when it exists successfully")
    void removeTodoItemSuccessfully(){
        // Scenario: Create TodoItem object, TodoItemDAOImpl object then add the TodoItem object to the TodoItemDAOImpl object
        Person personData = new Person("testFirstName", "testLastName", "test@email.se");
        TodoItem todoItemData = new TodoItem("Test title", "Test description", LocalDate.now().plusWeeks(2), false,personData );
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        TodoItem createdTodoItem = todoItemDAO.persist(todoItemData);

        // Expected:
        todoItemDAO.remove(createdTodoItem.getId());
        Collection<TodoItem> todoItems = todoItemDAO.findAll();

        // Verify: Check that the collection is empty
        assertTrue(todoItems.isEmpty());
    }
}
