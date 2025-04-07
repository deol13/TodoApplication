package se.lexicon.Data;

import se.lexicon.Model.TodoItem;
import se.lexicon.Model.TodoItemTask;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOCollection implements TodoItemDAO{
    private ArrayList<TodoItem> todoItemCollection;

    public TodoItemDAOCollection(){
        todoItemCollection = new ArrayList<TodoItem>();
    }

    @Override
    public void persist(TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("Error: todoItem object can't be null!");
        todoItemCollection.add(todoItem);
    }

    @Override
    public TodoItem findById(int id) {
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItemCollection;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        Object[] newObjArr = todoItemCollection.stream().filter(obj -> obj.isDone() == done).toArray();
        return List.of((TodoItem[]) newObjArr);
    }

    @Override
    public Collection<TodoItem> findAllByTitleContains(String title) {
        Object[] newObjArr = todoItemCollection.stream().filter(obj -> obj.getTitle().equals(title)).toArray();
        return List.of((TodoItem[]) newObjArr);
    }

    @Override
    public Collection<TodoItem> findAllByPersonId(int personId) {
        Object[] newObjArr = todoItemCollection.stream().filter(obj -> obj.getCreator().getId() == personId).toArray();
        return List.of((TodoItem[]) newObjArr);
    }

    @Override
    public Collection<TodoItem> findAllByDeadlineBefore(LocalDate date) {
        Object[] newObjArr = todoItemCollection.stream().filter(obj -> obj.getDeadLine().isBefore(date)).toArray();
        return List.of((TodoItem[]) newObjArr);
    }

    @Override
    public Collection<TodoItem> findAllByDeadlineAfter(LocalDate date) {
        Object[] newObjArr = todoItemCollection.stream().filter(obj -> obj.getDeadLine().isAfter(date)).toArray();
        return List.of((TodoItem[]) newObjArr);
    }

    @Override
    public void remove(int id) {
        TodoItem[] arr = (TodoItem[]) todoItemCollection.toArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getId() == id) {
                todoItemCollection.remove(i);
                break;
            }
        }
    }
}
