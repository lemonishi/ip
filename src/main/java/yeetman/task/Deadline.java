package yeetman.task;

import java.time.LocalDateTime;

/**
 * Encapsulates the logic of deadline tasks.
 */
public class Deadline extends Task {
    private LocalDateTime dueDate;

    /**
     * Instantiates a new Deadline instance.
     *
     * @param description Description of the Deadline task.
     * @param dueDate Due date of the task.
     */
    public Deadline(String description, LocalDateTime dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toSaveString() {
        return String.format("D | %d | %s | %s", isDone ? 1 : 0, description, dueDate.format(FORMATTER));
    }

    @Override
    public String toString() {
        String dueDateOutput = this.dueDate.format(FORMATTER);
        return String.format("[D]%s (by: %s)", super.toString(), dueDateOutput);
    }
}
