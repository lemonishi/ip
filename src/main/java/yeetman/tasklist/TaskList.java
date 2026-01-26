package yeetman.tasklist;

import java.util.ArrayList;

import yeetman.task.Task;

/**
 * Stores all the tasks added and handles essential features such as
 * getting and deleting tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Initializes a new empty TaskList instance.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Initializes a new TaskList instance and populating it with
     * another pre-populated list of tasks.
     *
     * @param loadedTasks Pre-populated list of tasks.
     */
    public TaskList(ArrayList<Task> loadedTasks) {
        this.tasks = loadedTasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task Task to add.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Deletes a task from the list.
     *
     * @param taskNumber Number tagged to the task to be deleted.
     */
    public void deleteTask(int taskNumber) {
        Task removed = this.tasks.get(taskNumber - 1);
        this.tasks.remove(removed);
    }

    public Task getTask(int index) {
        return this.tasks.get(index);
    }

    public int getTaskCount() {
        return this.tasks.size();
    }

    @Override
    public String toString() {
        String outputList = "";
        for (Task task : tasks) {
            outputList += String.format("%d. %s\n", tasks.indexOf(task) + 1, task);
        }
        return outputList;
    }
}
