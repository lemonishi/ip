package yeetman;

import yeetman.command.Command;
import yeetman.exception.YeetManException;
import yeetman.parser.Parser;
import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * The YeetMan class implements a chatbot application that
 * allows users to add, mark, and delete various types of tasks.
 *
 * @author Lennon Leung
 * @version 0.1
 */
public class YeetMan {

    private TaskList tasks;
    private Ui ui;
    private Storage storage;

    /**
     * Initializes a new YeetMan instance.
     *
     * @param filePath File path of txt file containing saved data.
     */
    public YeetMan(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            this.tasks = new TaskList(storage.load());
        } catch (YeetManException e) {
            this.tasks = new TaskList();
        }
    }

    /**
     * Starts the application and handles user input.
     * Terminates when the exit command is given.
     */
    public void run() {
        this.ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(this.tasks, this.ui, this.storage);
                isExit = c.isExit();
            } catch (YeetManException e) {
                System.out.println(e.getMessage());
            } finally {
                this.ui.showLine();
            }
        }
    }

    /**
     * Parses command-line arguments and runs the main application logic.
     *
     * @param args
     */
    public static void main(String[] args) {
        new YeetMan("data/yeetman.txt").run();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(this.tasks, this.ui, this.storage);
        } catch (YeetManException e) {
            return e.getMessage();
        }
    }
}
