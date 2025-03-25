package se.lexicon;

import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    TodoItem(int id, String title, String taskDescription, LocalDate deadline, boolean done, Person creator) {
        this.id = id;
        setTitle(title);
        this.taskDescription = taskDescription;
        setDeadLine(deadline);
        this.done = done;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title should not be null or empty");
        this.title = title;

    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) throw new IllegalArgumentException("Deadline should not be null");
        this.deadLine = deadLine;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue() {
        LocalDate date = LocalDate.now();

        return date.isAfter(deadLine);
    }

    public String getSummary() {
        return "id: " + id
                + ", title: " + title
                + ", description: " + taskDescription
                + ", deadline: " + deadLine
                + ", done: " + done
                + ", creator: " + creator.getFirstName() + " " + creator.getLastName();
    }
}
