package yeetman.ui;

import yeetman.task.Task;
import yeetman.tasklist.TaskList;

import java.util.Scanner;

public class Ui {
    private final String LINE = "____________________________________________________________";
    private Scanner scanner = new Scanner(System.in);

    public void showLine() {
        System.out.println(LINE);
    }

    public void showWelcome() {
        String greeting = String.format("%s\nHello! I'm YeetMan. It's just me Uce!\n"
                + "What can I do for you?\n%s\n", LINE, LINE);
        System.out.println(greeting);
    }

    public void showTaskList(TaskList tasks) {
        String header = "Here are the tasks in your list, Uce! :";
        System.out.printf("%s\n%s", header, tasks);
    }

    public void showAddMessage(Task added, TaskList tasks) {
        System.out.printf("Added this task:\n\t%s\nYou now have %d tasks, Uce!\n", added, tasks.getTaskCount());
    }

    public void showDeleteMessage(Task removed, TaskList tasks) {
        System.out.printf("This task has been removed:\n\t%s\nYou now have %d tasks left, Uce!\n", removed, tasks.getTaskCount());
    }

    public void showMarkMessage(Task task) {
        System.out.printf("YEET! Marked this task as done:\n\t%s\n", task);
    }

    public void showUnmarkMessage(Task task) {
        System.out.printf("NO YEET! Marked this task as not done yet:\n\t%s\n", task);
    }

    public void showExitMessage() {
        System.out.println("See you soon, Uce! 4 LETTERS, 1 WORD, UH UH, YEET!");
    }

    public String readCommand() {
       return scanner.nextLine();
    }
}
