package yeetman.parser;

import yeetman.command.AddDeadlineCommand;
import yeetman.command.AddEventCommand;
import yeetman.command.AddToDoCommand;
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
     * @param input Input given by the user.
     * @return Command with type of command depending on the input.
     * @throws YeetManException If there are invalid details for certain commands.
     */
    public static Command parse(String input) throws YeetManException {
        String[] split = splitInput(input);
        String command = split[0];
        String arguments = split[1];
        switch (command) {
        case "todo":
            return new AddToDoCommand(arguments);
        case "deadline":
            return new AddDeadlineCommand(arguments);
        case "event":
            return new AddEventCommand(arguments);
        case "delete":
            return new DeleteCommand(arguments);
        case "mark":
            return new MarkCommand(arguments);
        case "unmark":
            return new UnmarkCommand(arguments);
        case "list":
            return new ListCommand("");
        case "find":
            return new FindCommand(arguments);
        case "bye":
            return new ExitCommand("");
        default:
            throw new YeetManException("Invalid command Uce!");
        }
    }

    /**
     * Splits input for neater handling of input to parse.
     *
     * @param input User Input.
     * @return An array containing the command and arguments, if any.
     */
    private static String[] splitInput(String input) {
        int firstSpaceIndex = input.indexOf(" ");
        boolean hasSpace = firstSpaceIndex != -1;
        boolean hasArg = firstSpaceIndex + 1 < input.length() && hasSpace;
        String command = hasSpace ? input.substring(0, firstSpaceIndex) : input;
        String arguments = hasArg ? input.substring(firstSpaceIndex + 1).trim() : "";
        return new String[]{command, arguments};
    }
}
