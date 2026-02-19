package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.Task;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Deletes a task from the task list.
 */
public class DeleteCommand extends Command {
    public DeleteCommand(String arguments) {
        super(arguments);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(arguments);
            if (taskNumber > tasks.getTaskCount() || taskNumber < 0) {
                throw new YeetManException(String.format("Task number %d does not exist, Uce!", taskNumber));
            }
            Task deleted = tasks.getTask(taskNumber - 1);
            tasks.deleteTask(taskNumber);
            storage.save(tasks);
            return ui.showDeleteMessage(deleted, tasks);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to delete, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
