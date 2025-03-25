package se.lexicon;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this.id = id;
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

    public String getSummary() {
        return "id: " + id
                + ", assigned: " + assigned
                + ", todoItem: " + todoItem.getTitle()
                + ", assignee: " + assignee.getFirstName() + " " + assignee.getLastName();
    }
}
