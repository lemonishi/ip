package yeetman.command;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

public class AddCommandTest {
    private TaskList tasks;
    private Ui ui;
    private Storage storage;

    @BeforeEach
    public void setUp() {
        this.tasks = new TaskList();
        this.ui = new Ui();
        this.storage = new Storage("");
    }

    @Test
    public void givenDeadlineWithEmptyDate_whenExecute_throwException() {
        Command c = new AddCommand("deadline with no due date", "deadline");
        assertThrows(YeetManException.class, () -> c.execute(tasks, ui, storage));
    }

    @Test
    public void givenEventWithEmptyDates_whenExecute_throwException() {
        Command c = new AddCommand("event with no start and end", "event");
        assertThrows(YeetManException.class, () -> c.execute(tasks, ui, storage));
    }

    @Test
    public void givenEventWithEmptyStartDate_whenExecute_throwException() {
        Command c = new AddCommand("event with no start /to 18/1/2023 1800", "event");
        assertThrows(YeetManException.class, () -> c.execute(tasks, ui, storage));
    }

    @Test
    public void givenEventWithEmptyEndDate_whenExecute_throwException() {
        Command c = new AddCommand("event with no end /from 18/1/2023 1800", "event");
        assertThrows(YeetManException.class, () -> c.execute(tasks, ui, storage));
    }
}
