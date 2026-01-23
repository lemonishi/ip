package yeetman.command;

import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

public class ListCommand extends Command {
    public ListCommand(String info) {
        super(info);
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks);
    }

    public boolean isExit() {
        return false;
    }
}
