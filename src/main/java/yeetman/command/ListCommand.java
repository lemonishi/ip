package yeetman.command;

import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Displays the list of tasks in the task list currently.
 */
public class ListCommand extends Command {
    public ListCommand(String info) {
        super(info);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.showTaskList(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
