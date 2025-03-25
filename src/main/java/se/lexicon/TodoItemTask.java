package se.lexicon;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    //todo: TodoItem can be null in the constructor, fix it!
    TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this.id = id;
        setTodoItem(todoItem);
        this.assignee = assignee;
        assigned = assignee != null;
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        if (assigned && assignee != null) {
            this.assigned = assigned;
        } else if (!assigned) {
            this.assigned = assigned;
        }

    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem != null) {
            this.todoItem = todoItem;
        }
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        if (assignee != null) {
            assigned = true;
        }
    }

    public String getSummary() {
        return "id: " + id
                + ", assigned: " + assigned
                + ", todoItem: " + todoItem.getTitle()
                + ", assignee: " + assignee.getFirstName() + " " + assignee.getLastName();
    }
}
