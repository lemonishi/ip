package yeetman.command;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.task.ToDo;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

public class AddToDoCommand extends AddCommand {

    public AddToDoCommand(String arguments) {
        super(arguments);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        if (arguments.isEmpty()) {
            throw new YeetManException("Details of a todo cannot be empty, Uce!");
        }
        ToDo toDo = new ToDo(arguments);
        tasks.addTask(toDo);
        storage.save(tasks);
        return ui.showAddMessage(toDo, tasks);
    }
}
