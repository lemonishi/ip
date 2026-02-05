package yeetman.command;

import java.util.stream.Collectors;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Finds and lists all tasks containing the input string in its description.
 */
public class FindCommand extends Command {
    public FindCommand(String info) {
        super(info);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {

        String output = tasks.toString()
                .lines()
                .filter(line -> {
                    int start = line.indexOf("] ");
                    int end = line.indexOf("(");
                    if (end == -1) {
                        end = line.length();
                    }
                    String name = line.substring(start + 2, end).trim();
                    return name.contains(this.arguments);
                })
                .collect(Collectors.joining("\n"));
        if (output.isEmpty()) {
            return "No matching tasks found, Uce!";
        }
        return "Here are the matching tasks in your list, Uce:\n" + output;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
