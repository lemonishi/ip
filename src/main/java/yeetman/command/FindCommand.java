package yeetman.command;

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
        String output = "";
        String[] lines = tasks.toString().split("\\R");
        for (String line : lines) {
            int start = line.indexOf("] ");
            int end = line.indexOf("(");
            if (end == -1) {
                end = line.length();
            }
            String name = line.substring(start + 2, end).trim();
            if (name.contains(this.info)) {
                output += line + "\n";
            }
        }
        if (output.isEmpty()) {
            System.out.println("No matching tasks found, Uce!");
            return "No matching tasks found, Uce!";
        } else {
            System.out.printf("Here are the matching tasks in your list, Uce:\n"
                    + output);
            return String.format("Here are the matching tasks in your list, Uce:\n"
                    + output);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
