package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.Deadline;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class AddDeadlineCommand extends AddCommand {

    public AddDeadlineCommand(String arguments) {
        super(arguments);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        String[] split = arguments.split(" /by ");
        if (split.length != 2) {
            String format = "deadline <task_name> /by <d/M/yyyy HHmm>";
            String error = String.format("Invalid format for deadlines, Uce! Format is %s.", format);
            throw new YeetManException(error);
        }
        try {
            LocalDateTime dueDate = LocalDateTime.parse(split[1], INPUT_FORMATTER);
            Deadline deadline = new Deadline(split[0], dueDate);
            tasks.addTask(deadline);
            storage.save(tasks);
            return ui.showAddMessage(deadline, tasks);
        } catch (DateTimeParseException e) {
            throw new YeetManException("Enter date and time in d/M/yyyy HHmm format, Uce!");
        }
    }
}
