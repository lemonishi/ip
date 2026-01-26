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
 * Adds a task to the task list.
 */
public class AddCommand extends Command {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private String taskType;

    /**
     * Instantiates an AddCommand instance.
     *
     * @param info Details of the input.
     * @param taskType Type of task to add.
     */
    public AddCommand(String info, String taskType) {
        super(info);
        this.taskType = taskType;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        switch (this.taskType) {
        case "todo":
            if (info.isEmpty()) {
                throw new YeetManException("Tasks must have a name, Uce!");
            }
            ToDo todo = new ToDo(info);
            tasks.addTask(todo);
            storage.save(tasks);
            return ui.showAddMessage(todo, tasks);
        case "deadline": {
            if (info.split("/by").length == 1) {
                throw new YeetManException("Deadline tasks need a deadline, Uce!");
            }
            try {
                String name = info.split("/by")[0].trim();
                String dueDate = info.split("/by")[1].trim();
                LocalDateTime dueDateInput = LocalDateTime.parse(dueDate, INPUT_FORMATTER);
                Deadline deadline = new Deadline(name, dueDateInput);
                tasks.addTask(deadline);
                storage.save(tasks);
                return ui.showAddMessage(deadline, tasks);
            } catch (DateTimeParseException e) {
                throw new YeetManException("Enter date and time in d/M/yyyy HHmm format, Uce!");
            }
        }
        case "event": {
            if (info.split("/from").length == 1 || info.split("/to").length == 1) {
                throw new YeetManException("Event tasks need a start and end date, Uce!");
            }
            try {
                String name = info.split("/from")[0].trim();
                String startDate = info.split("/from|/to")[1].trim();
                String endDate = info.split("/to")[1].trim();
                LocalDateTime startDateInput = LocalDateTime.parse(startDate, INPUT_FORMATTER);
                LocalDateTime endDateInput = LocalDateTime.parse(endDate, INPUT_FORMATTER);
                Event event = new Event(name, startDateInput, endDateInput);
                tasks.addTask(event);
                storage.save(tasks);
                return ui.showAddMessage(event, tasks);
            } catch (DateTimeParseException e) {
                throw new YeetManException("Enter date and time in d/M/yyyy HHmm format, Uce!");
            }
        }
        default:
            throw new YeetManException("Unable to add task, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
