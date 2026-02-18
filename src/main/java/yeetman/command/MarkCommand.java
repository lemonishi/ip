package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.Task;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Marks a task.
 */
public class MarkCommand extends Command {
    public MarkCommand(String arguments) {
        super(arguments);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(arguments);
            if (taskNumber > tasks.getTaskCount() || taskNumber < 0) {
                throw new YeetManException(String.format("Task number %d does not exist, Uce!", taskNumber));
            }
            Task marked = tasks.getTask(taskNumber - 1);
            marked.markAsDone();
            storage.save(tasks);
            return ui.showMarkMessage(marked);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to mark as done, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
