package se.lexicon.Data.Impl;

import se.lexicon.Data.TodoItemDAO;
import se.lexicon.Model.Person;
import se.lexicon.Model.TodoItem;

import java.time.LocalDate;
import java.util.*;

public class TodoItemDAOImpl implements TodoItemDAO<TodoItem> {
    private ArrayList<TodoItem> todoItemCollection;

    public TodoItemDAOImpl(){
        todoItemCollection = new ArrayList<TodoItem>();
    }

    @Override
    public void persist(TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("Error: todoItem object can't be null!");
        todoItemCollection.add(todoItem);
    }

    @Override
    public TodoItem findById(int id) {
        Optional<TodoItem> todoItemOptional = todoItemCollection.stream().filter(t -> t.getId() == id).findFirst();

        return todoItemOptional.orElse(null);
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItemCollection;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return todoItemCollection.stream().filter(t -> t.isDone() == done).toList();
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return todoItemCollection.stream().filter(t -> t.getTitle().equals(title)).toList();
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return todoItemCollection.stream().filter(t -> t.getCreator() != null && t.getCreator().getId() == personId).toList();
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        return todoItemCollection.stream().filter(t -> t.getDeadLine().isBefore(date)).toList();
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItemCollection.stream().filter(t -> t.getDeadLine().isAfter(date)).toList();
    }

    @Override
    public void remove(int id) {
        TodoItem item = findById(id);
        if(item != null) todoItemCollection.remove(item);
    }
}
