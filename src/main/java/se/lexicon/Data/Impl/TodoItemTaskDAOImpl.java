package se.lexicon.Data.Impl;

import se.lexicon.Data.TodoItemTaskDAO;
import se.lexicon.Model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;

public class TodoItemTaskDAOImpl implements TodoItemTaskDAO<TodoItemTask> {
    private ArrayList<TodoItemTask> todoItemTaskCollection;

    public TodoItemTaskDAOImpl(){
        todoItemTaskCollection = new ArrayList<TodoItemTask>();
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        if(todoItemTask == null) throw new IllegalArgumentException("Error: todoItemTask object can't be null!");
        todoItemTaskCollection.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        int index = findIndexById(id);
        if(index > -1) return todoItemTaskCollection.get(index);
        return null;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        return todoItemTaskCollection.stream().filter(t -> t.isAssigned() == status).toList();
    }

    //todo fix
    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return todoItemTaskCollection.stream().filter(t -> t.isAssigned() && t.getAssignee().getId() == personId).toList();
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
        for (int i = 0; i < todoItemTaskCollection.size(); i++) {
            if(todoItemTaskCollection.get(i).getId() == id)
                return i;
        }
        return -1;
    }
}
