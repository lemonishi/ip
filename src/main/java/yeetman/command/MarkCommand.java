package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.Task;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

public class MarkCommand extends Command {
    public MarkCommand(String info) {
        super(info);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(info);
            Task marked = tasks.getTask(taskNumber - 1);
            marked.markAsDone();
            storage.save(tasks);
            ui.showMarkMessage(marked);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to mark as done, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
