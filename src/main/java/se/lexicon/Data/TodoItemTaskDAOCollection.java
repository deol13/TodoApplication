package se.lexicon.Data;

import se.lexicon.Model.Person;
import se.lexicon.Model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO{
    private ArrayList<TodoItemTask> todoItemTaskCollection;

    public TodoItemTaskDAOCollection(){
        todoItemTaskCollection = new ArrayList<TodoItemTask>();
    }

    @Override
    public void persist(TodoItemTask todoItemTask) {
        if(todoItemTask == null) throw new IllegalArgumentException("Error: todoItemTask object can't be null!");
        todoItemTaskCollection.add(todoItemTask);
    }

    @Override
    public TodoItemTask findById(int id) {
        int index = findIndexById(id);
        if(index > -1) return todoItemTaskCollection.get(index);
        return null;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        Object[] newObjArr = todoItemTaskCollection.stream().filter(obj -> obj.isAssigned() == status).toArray();
        return List.of((TodoItemTask[]) newObjArr);
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        Object[] newObjArr = todoItemTaskCollection.stream().filter(obj -> obj.getAssignee().getId() == personId).toArray();
        return List.of((TodoItemTask[]) newObjArr);
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return todoItemTaskCollection;
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        if(index > -1) todoItemTaskCollection.remove(index);
    }

    private int findIndexById(int id){
        TodoItemTask[] arr = (TodoItemTask[]) todoItemTaskCollection.toArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getId() == id)
                return i;
        }
        return -1;
    }
}
