package yeetman.task;

import java.time.format.DateTimeFormatter;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }
}
