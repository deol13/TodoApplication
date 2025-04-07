package se.lexicon.Data;

import se.lexicon.Model.TodoItemTask;
import java.util.Collection;

public interface TodoItemTaskDAO {

    void persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findByAssignedStatus (boolean status);
    Collection<TodoItemTask> findByPersonId (int personId);
    Collection<TodoItemTask> findAll();
    void remove(int id);
}
