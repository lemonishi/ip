package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.Event;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class AddEventCommand extends AddCommand {
    public AddEventCommand(String arguments) {
        super(arguments);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        int fromIndex = arguments.indexOf(" /from ");
        int toIndex = arguments.indexOf(" /to ");
        String[] split = arguments.split(" /from ");
        if (fromIndex == -1 || toIndex == -1 || split.length != 2) {
            String format = "event <task_name> /from d/M/yyyy HHmm /to d/M/yyyy HHmm";
            String error = String.format("Invalid format for events, Uce! Format is %s.", format);
            throw new YeetManException(error);
        }
        try {
            LocalDateTime startDate = LocalDateTime.parse(arguments.substring(fromIndex + 7, toIndex), INPUT_FORMATTER);
            LocalDateTime endDate = LocalDateTime.parse(arguments.substring(toIndex + 5), INPUT_FORMATTER);
            Event event = new Event(split[0], startDate, endDate);
            tasks.addTask(event);
            storage.save(tasks);
            return ui.showAddMessage(event, tasks);
        } catch (DateTimeParseException e) {
            throw new YeetManException("Enter date and time in d/M/yyyy HHmm format, Uce!");
        }
    }
}
