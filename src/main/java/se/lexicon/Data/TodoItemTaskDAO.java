package se.lexicon.Data;

import se.lexicon.Model.TodoItemTask;
import java.util.Collection;

public interface TodoItemTaskDAO<T> {

    void persist(T todoItemTask);
    T findById(int id);
    Collection<T> findByAssignedStatus (boolean status);
    Collection<T> findByPersonId (int personId);
    Collection<T> findAll();
    void remove(int id);
}
