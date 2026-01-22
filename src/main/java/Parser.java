public class Parser {
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
                return new MarkCommand(fullCommand.split(" ")[1]);
            case "unmark":
                return new UnmarkCommand(fullCommand.split(" ")[1]);
            case "list":
                return new ListCommand("");
            case "bye":
                return new ExitCommand("");
            default:
                throw new YeetManException("Invalid command Uce!");
        }
    }
}
