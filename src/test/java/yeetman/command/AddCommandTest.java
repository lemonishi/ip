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
        Command c = new AddDeadlineCommand("deadline with no due date");
        assertThrows(YeetManException.class, () -> c.execute(tasks, ui, storage));
    }

    @Test
    public void givenEventWithEmptyDates_whenExecute_throwException() {
        Command c = new AddEventCommand("event with no start and end");
        assertThrows(YeetManException.class, () -> c.execute(tasks, ui, storage));
    }

    @Test
    public void givenEventWithEmptyStartDate_whenExecute_throwException() {
        Command c = new AddEventCommand("event with no start /to 18/1/2023 1800");
        assertThrows(YeetManException.class, () -> c.execute(tasks, ui, storage));
    }

    @Test
    public void givenEventWithEmptyEndDate_whenExecute_throwException() {
        Command c = new AddEventCommand("event with no end /from 18/1/2023 1800");
        assertThrows(YeetManException.class, () -> c.execute(tasks, ui, storage));
    }
}
