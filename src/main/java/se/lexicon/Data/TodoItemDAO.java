package se.lexicon.Data;

import se.lexicon.Model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO<T> {

    void persist(T todoItem);
    T findById(int id);
    Collection<T> findAll();
    Collection<T> findAllByDoneStatus(boolean done);
    Collection<T> findByTitleContains(String title);
    Collection<T> findByPersonId(int personId);
    Collection<T> findByDeadlineBefore(LocalDate date);
    Collection<T> findByDeadlineAfter(LocalDate date);
    void remove(int id);
}
