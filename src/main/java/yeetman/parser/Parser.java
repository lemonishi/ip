package yeetman.parser;

import yeetman.command.AddCommand;
import yeetman.command.Command;
import yeetman.command.DeleteCommand;
import yeetman.command.ExitCommand;
import yeetman.command.FindCommand;
import yeetman.command.ListCommand;
import yeetman.command.MarkCommand;
import yeetman.command.UnmarkCommand;
import yeetman.exception.YeetManException;

/**
 * Encapsulates the parsing logic.
 */
public class Parser {
    /**
     * Parses the user input and directs the logic to the respective commands.
     *
     * @param fullCommand Input given by the user.
     * @return Command with type of command depending on the input.
     * @throws YeetManException If there are invalid details for certain commands.
     */
    public static Command parse(String fullCommand) throws YeetManException {
        String commandType = fullCommand.split(" ")[0];
        switch (commandType) {
        case "todo":
        case "deadline":
        case "event":
            if (fullCommand.split(" ").length == 1) {
                throw new YeetManException("Task details cannot be empty, Uce!");
            }
            return new AddCommand(fullCommand.split(" ", 2)[1], commandType);
        case "delete":
            if (fullCommand.split(" ").length == 1) {
                throw new YeetManException("Specify which task number you wanna delete Uce!");
            }
            return new DeleteCommand(fullCommand.split(" ")[1]);
        case "mark":
            if (fullCommand.split(" ").length == 1) {
                throw new YeetManException("Enter the task number you want to mark as done, Uce!");
            }
            return new MarkCommand(fullCommand.split(" ")[1]);
        case "unmark":
            if (fullCommand.split(" ").length == 1) {
                throw new YeetManException("Enter the task number you want to mark as not done, Uce!");
            }
            return new UnmarkCommand(fullCommand.split(" ")[1]);
        case "list":
            return new ListCommand("");
        case "find":
            if (fullCommand.split(" ").length == 1) {
                throw new YeetManException("Tell me whatchu wanna find, Uce!");
            }
            return new FindCommand(fullCommand.split(" ", 2)[1]);
        case "bye":
            return new ExitCommand("");
        default:
            throw new YeetManException("Invalid command Uce!");
        }
    }
}
