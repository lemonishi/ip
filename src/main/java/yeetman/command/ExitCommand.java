package yeetman.command;

import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Terminates the application.
 */
public class ExitCommand extends Command {
    public ExitCommand(String info) {
        super(info);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showExitMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
