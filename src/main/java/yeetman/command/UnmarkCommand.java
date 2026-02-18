package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.Task;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Unmarks a task.
 */
public class UnmarkCommand extends Command {
    public UnmarkCommand(String arguments) {
        super(arguments);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(arguments);
            if (taskNumber > tasks.getTaskCount() || taskNumber < 0) {
                throw new YeetManException(String.format("Task number %d does not exist, Uce!", taskNumber));
            }
            Task unmarked = tasks.getTask(taskNumber - 1);
            unmarked.markAsUndone();
            storage.save(tasks);
            return ui.showUnmarkMessage(unmarked);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to mark as undone, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
