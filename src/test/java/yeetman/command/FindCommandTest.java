package yeetman.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import yeetman.exception.YeetManException;
import yeetman.storage.Storage;
import yeetman.tasklist.TaskList;
import yeetman.ui.Ui;

/**
 * Tests for FindCommand.
 */
public class FindCommandTest {

    /**
     * Stub TaskList that allows us to control toString().
     */
    private static class StubTaskList extends TaskList {
        private final String output;

        StubTaskList(String output) {
            super();
            this.output = output;
        }

        @Override
        public String toString() {
            return output;
        }
    }

    private static final Ui DUMMY_UI = new Ui();
    private static final Storage DUMMY_STORAGE = null;

    @Test
    public void givenMatchingTasks_whenExecute_thenMatchingTasksReturned() throws YeetManException {
        String taskListOutput =
                "1.[T][ ] read book (deadline: tomorrow)\n"
                        + "2.[E][X] attend meeting\n"
                        + "3.[T][ ] read notes";

        TaskList tasks = new StubTaskList(taskListOutput);
        FindCommand command = new FindCommand("read");

        String result = command.execute(tasks, DUMMY_UI, DUMMY_STORAGE);

        String expected =
                "Here are the matching tasks in your list, Uce:\n"
                        + "1.[T][ ] read book (deadline: tomorrow)\n"
                        + "3.[T][ ] read notes";

        assertEquals(expected, result);
    }

    @Test
    public void givenNoMatchingTasks_whenExecute_thenNoMatchMessageReturned() throws YeetManException {
        String taskListOutput =
                "1.[T][ ] read book\n"
                        + "2.[E][ ] attend meeting";

        TaskList tasks = new StubTaskList(taskListOutput);
        FindCommand command = new FindCommand("sleep");

        String result = command.execute(tasks, DUMMY_UI, DUMMY_STORAGE);

        assertEquals("No matching tasks found, Uce!", result);
    }

    @Test
    public void givenPartialWordMatch_whenExecute_thenMatchingTasksReturned() throws YeetManException {
        String taskListOutput =
                "1.[T][ ] homework\n"
                        + "2.[T][ ] home cleaning";

        TaskList tasks = new StubTaskList(taskListOutput);
        FindCommand command = new FindCommand("home");

        String result = command.execute(tasks, DUMMY_UI, DUMMY_STORAGE);

        String expected =
                "Here are the matching tasks in your list, Uce:\n"
                        + "1.[T][ ] homework\n"
                        + "2.[T][ ] home cleaning";

        assertEquals(expected, result);
    }

    @Test
    public void givenFindCommand_whenIsExitCalled_thenReturnFalse() {
        FindCommand command = new FindCommand("anything");
        assertFalse(command.isExit());
    }
}
