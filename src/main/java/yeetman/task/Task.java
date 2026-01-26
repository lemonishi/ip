package yeetman.task;

import java.time.format.DateTimeFormatter;

/**
 * Encapsulates the logic of all types of tasks.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    /**
     * Instantiates a Task instance
     *
     * @param description Description of the task, including information like dates if applicable.
     */
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
