package yeetman.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void givenInfo_whenCreateToDo_returnCorrectToString() {
        Task todo = new ToDo("test");
        assertEquals("[T][ ] test", todo.toString());
    }

    @Test
    public void givenInfo_whenCreateTask_returnUndoneTask() {
        Task todo = new ToDo("should be undone by default");
        assertEquals(" ", todo.getStatusIcon());
    }

    @Test
    public void givenTaskNumber_whenMarkTask_returnMarkStatus() {
        Task todo = new ToDo("test");
        todo.markAsDone();
        assertEquals("X", todo.getStatusIcon());
    }

    @Test
    public void givenTaskNumber_whenUnmarkTask_returnUnmarkStatus() {
        Task todo = new ToDo("test");
        // By order of tests, if the test above passes and this test also passes, unmarking works.
        todo.markAsDone();
        todo.markAsUndone();
        assertEquals(" ", todo.getStatusIcon());
    }
}
