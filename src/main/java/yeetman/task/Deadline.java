package yeetman.task;

import java.time.LocalDateTime;

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
    public String toString() {
        String dueDateOutput = this.dueDate.format(FORMATTER);
        return String.format("[D]%s (by: %s)", super.toString(), dueDateOutput);
    }
}
