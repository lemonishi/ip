package yeetman.task;

/**
 * Encapsulates the logic of todo tasks.
 */
public class ToDo extends Task {
    /**
     * Instantiates a new ToDo instance.
     *
     * @param description Task description.
     */
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
