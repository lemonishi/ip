package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.Deadline;
import yeetman.task.Event;
import yeetman.task.ToDo;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Adds a task to the task list.
 */
public class AddCommand extends Command {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private String taskType;

    public AddCommand(String info, String taskType) {
        super(info);
        this.taskType = taskType;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        switch (this.taskType) {
            case "todo":
                if (info.isEmpty()) {
                    throw new YeetManException("Tasks must have a name, Uce!");
                }
                ToDo todo = new ToDo(info);
                tasks.addTask(todo);
                storage.save(tasks);
                ui.showAddMessage(todo, tasks);
                break;
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
                    ui.showAddMessage(deadline, tasks);
                    break;
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
                    ui.showAddMessage(event, tasks);
                    break;
                } catch (DateTimeParseException e) {
                    throw new YeetManException("Enter date and time in d/M/yyyy HHmm format, Uce!");
                }
            }
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
