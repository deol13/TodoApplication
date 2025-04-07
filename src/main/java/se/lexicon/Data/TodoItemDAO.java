package se.lexicon.Data;

import se.lexicon.Model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {

    void persist(TodoItem todoItem);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findAllByTitleContains(String title);
    Collection<TodoItem> findAllByPersonId(int personId);
    Collection<TodoItem> findAllByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findAllByDeadlineAfter(LocalDate date);
    void remove(int id);
}
