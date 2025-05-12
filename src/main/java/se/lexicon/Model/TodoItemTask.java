package se.lexicon.Model;

import se.lexicon.Sequencers.TodoItemTaskIdSequencer;

public class TodoItemTask {
    private final int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        id = TodoItemTaskIdSequencer.nextId();
        setTodoItem(todoItem);
        setAssignee(assignee);
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException("todoItem should not be null");
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        assigned = (assignee != null);
    }

    // Overrides equals from Java.Lang.Object
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        TodoItemTask user = (TodoItemTask) other;
        return id == user.id && assigned == user.assigned && todoItem.equals(user.todoItem);
    }

    // Overrides hashCode from Java.Lang.Object
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash * todoItem.hashCode();
        return hash;
    }

    // Overrides toString from Java.Lang.Object
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TodoItemTask ID: ").append(id);
        sb.append("\nAssigned: ").append(assigned);
        sb.append("\nTodoItem: ").append(todoItem.toString());
        return sb.toString();
    }
}
