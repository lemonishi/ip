package yeetman.tasklist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yeetman.task.Deadline;
import yeetman.task.Task;
import yeetman.task.ToDo;

public class TaskListTest {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private TaskList taskList;

    @BeforeEach
    public void setUp() {
        this.taskList = new TaskList();
    }

    @Test
    public void givenTask_whenAddTask_thenIncrementCount() {
        Task todo = new ToDo("test todo");
        Task deadline = new Deadline("test deadline",
                LocalDateTime.parse("1/1/2000 1800", INPUT_FORMATTER));
        this.taskList.addTask(todo);
        this.taskList.addTask(deadline);
        assertEquals(2, this.taskList.getTaskCount());
    }

    @Test
    public void givenTask_whenDeleteTask_thenDecrementCount() {
        Task todo = new ToDo("test todo");
        Task deadline = new Deadline("test deadline",
                LocalDateTime.parse("1/1/2000 1800", INPUT_FORMATTER));
        this.taskList.addTask(todo);
        this.taskList.addTask(deadline);
        assertEquals(2, this.taskList.getTaskCount());
        this.taskList.deleteTask(2);
        this.taskList.deleteTask(1);
        assertEquals(0, this.taskList.getTaskCount());
    }
}
