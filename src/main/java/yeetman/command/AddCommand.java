package yeetman.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.Deadline;
import yeetman.task.Event;
import yeetman.task.ToDo;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Encapsulates the logic of Add commands.
 */
public abstract class AddCommand extends Command {
    protected static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

    public AddCommand(String arguments) {
        super(arguments);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
