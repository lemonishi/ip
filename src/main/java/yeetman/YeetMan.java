package yeetman;

import yeetman.command.Command;
import yeetman.exception.YeetManException;
import yeetman.parser.Parser;
import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

public class YeetMan {

    private TaskList tasks;
    private Ui ui;
    private Storage storage;

    public YeetMan(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            this.tasks = new TaskList(storage.load());
        } catch (YeetManException e) {
            this.tasks = new TaskList();
        }
    }

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

    public static void main(String[] args) {
        new YeetMan("data/yeetman.txt").run();
    }
}