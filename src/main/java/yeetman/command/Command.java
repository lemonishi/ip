package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Encapsulates the logic for all types of commands.
 */
public abstract class Command {
    protected String info;

    /**
     * Instantiates a type of command, used by its subclasses.
     *
     * @param info Details of the input given without the type of command.
     */
    public Command(String info) {
        this.info = info;
    }

    /**
     * Executes action according to the type of command.
     * Override in each subclass differently.
     *
     * @param tasks List of tasks.
     * @param ui Ui instance.
     * @param storage Storage instance.
     * @throws YeetManException If an error for the individual command is found.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException;

    public abstract boolean isExit();
}
