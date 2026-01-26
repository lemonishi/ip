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
    public DeleteCommand(String info) {
        super(info);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(info);
            Task deleted = tasks.getTask(taskNumber - 1);
            tasks.deleteTask(taskNumber);
            storage.save(tasks);
            ui.showDeleteMessage(deleted, tasks);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to delete, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
