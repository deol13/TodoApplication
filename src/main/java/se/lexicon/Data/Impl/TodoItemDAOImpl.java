package se.lexicon.Data.Impl;

import se.lexicon.Data.TodoItemDAO;
import se.lexicon.Model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TodoItemDAOImpl implements TodoItemDAO {
    private ArrayList<TodoItem> todoItemCollection;

    public TodoItemDAOImpl(){
        todoItemCollection = new ArrayList<TodoItem>();
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("Error: todoItem object can't be null!");
        todoItemCollection.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        Iterator<TodoItem> itr = todoItemCollection.iterator();
        while (itr.hasNext()) {
            TodoItem item = itr.next();
            if(item.getId() == id)
                return item;
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItemCollection;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        ArrayList<TodoItem> newItems = new ArrayList<>();
        for (TodoItem task : todoItemCollection) {
            if(task.isDone() == done)
                newItems.add(task);
        }
        return newItems;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        ArrayList<TodoItem> newItems = new ArrayList<>();
        for (TodoItem task : todoItemCollection) {
            if(task.getTitle().equals(title))
                newItems.add(task);
        }
        return newItems;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        ArrayList<TodoItem> newItems = new ArrayList<>();
        for (TodoItem task : todoItemCollection) {
            if(task.getCreator() != null && task.getCreator().getId() == personId)
                newItems.add(task);
        }
        return newItems;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        ArrayList<TodoItem> newItems = new ArrayList<>();
        for (TodoItem task : todoItemCollection) {
            if(task.getDeadLine().isBefore(date))
                newItems.add(task);
        }
        return newItems;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        ArrayList<TodoItem> newItems = new ArrayList<>();
        for (TodoItem task : todoItemCollection) {
            if(task.getDeadLine().isAfter(date))
                newItems.add(task);
        }
        return newItems;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < todoItemCollection.size(); i++) {
            if(todoItemCollection.get(i).getId() == id) {
                todoItemCollection.remove(i);
                break;
            }
        }
    }
}
