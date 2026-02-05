package yeetman.command;

import java.time.format.DateTimeFormatter;

/**
 * Encapsulates the logic of Add commands.
 */
public abstract class AddCommand extends Command {
    protected static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

    public AddCommand(String arguments) {
        super(arguments);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
