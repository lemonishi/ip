package yeetman.ui;

import java.util.Scanner;

import yeetman.task.Task;
import yeetman.tasklist.TaskList;

/**
 * Handles the application's UI logic.
 */
public class Ui {
    private static final String LINE = "____________________________________________________________";
    private Scanner scanner = new Scanner(System.in);

    /**
     * Displays the visual line present in each response.
     */
    public void showLine() {
        System.out.println(LINE);
    }

    /**
     * Displays the welcome greeting on initial startup.
     */
    public void showWelcome() {
        String greeting = String.format("%s\nHello! I'm YeetMan. It's just me Uce!\n"
                + "What can I do for you?\n%s\n", LINE, LINE);
        System.out.println(greeting);
    }

    /**
     * Displays the task list when given the list command.
     *
     * @param tasks TaskList instance.
     */
    public void showTaskList(TaskList tasks) {
        String header = "Here are the tasks in your list, Uce! :";
        System.out.printf("%s\n%s", header, tasks);
    }

    /**
     * Displays the string of the task added after adding a task and the updated task count.
     *
     * @param added Task added.
     * @param tasks TaskList where the task is added to.
     */
    public void showAddMessage(Task added, TaskList tasks) {
        System.out.printf("Added this task:\n\t%s\nYou now have %d tasks, Uce!\n", added, tasks.getTaskCount());
    }

    /**
     * Displays the string of the task deleted after deleting a task and the updated task count.
     *
     * @param removed Task removed.
     * @param tasks TaskList where the task is removed from.
     */
    public void showDeleteMessage(Task removed, TaskList tasks) {
        System.out.printf("This task has been removed:\n\t%s\nYou now have %d tasks left, Uce!\n",
                removed, tasks.getTaskCount());
    }

    /**
     * Displays the string of the task marked after marking the task.
     *
     * @param task Task that got marked.
     */
    public void showMarkMessage(Task task) {
        System.out.printf("YEET! Marked this task as done:\n\t%s\n", task);
    }

    /**
     * Displays the string of the task unmarked after unmarking the task.
     *
     * @param task Task that got unmarked.
     */
    public void showUnmarkMessage(Task task) {
        System.out.printf("NO YEET! Marked this task as not done yet:\n\t%s\n", task);
    }

    /**
     * Displays the exit message upon running the exit command.
     */
    public void showExitMessage() {
        System.out.println("See you soon, Uce! 4 LETTERS, 1 WORD, UH UH, YEET!");
    }

    /**
     * Returns the user input on the command line.
     *
     * @return Input entered.
     */
    public String readCommand() {
        return scanner.nextLine();
    }
}
