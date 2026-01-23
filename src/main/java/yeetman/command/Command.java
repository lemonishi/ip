package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

public abstract class Command {
    protected String info;

    public Command(String info) {
        this.info = info;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException;

    public abstract boolean isExit();
}
