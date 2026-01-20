import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

public class YeetMan {

    private static ArrayList<Task> list = new ArrayList<>();
    private static int count = 0;
    private static final String LINE = "____________________________________________________________";
    private static final String FILE_PATH = "data/yeetman.txt";

    private static void handleToDo(String details) throws YeetManException {
        try {
            if (details.isEmpty()) {
                throw new YeetManException("The description of a todo cannot be empty Uce!");
            }
            ToDo todo = new ToDo(details);
            list.add(todo);
            count++;
            saveTask(FILE_PATH, list);
            System.out.printf("%s\nGot it. I've added this task:\n%s\nNow you have %d tasks in the list\n%s\n",
                    LINE, todo, count, LINE);
        } catch (IOException e) {
            throw new YeetManException(e.getMessage());
        }
    }

    private static void handleDeadline(String details) throws YeetManException {
        try {
            if (details.split("/by").length == 1) {
                throw new YeetManException("You need a due date for deadlines Uce!");
            }
            String name = details.split("/by")[0].trim();
            String dueDate = details.split("/by")[1].trim();
            Deadline deadline = new Deadline(name, dueDate);
            list.add(deadline);
            count++;
            saveTask(FILE_PATH, list);
            System.out.printf("%s\nGot it. I've added this task:\n%s\nNow you have %d tasks in the list\n%s\n",
                    LINE, deadline, count, LINE);
        } catch (IOException e) {
            throw new YeetManException(e.getMessage());
        }
    }

    private static void handleEvent(String details) throws YeetManException {
        try {
            if (details.split("/from").length == 1 || details.split("/to").length == 1) {
                throw new YeetManException("Events need to have a start and end date Uce!");
            }
            String name = details.split("/from")[0].trim();
            String startDate = details.split("/from|/to")[1].trim();
            String endDate = details.split("/to")[1].trim();
            Event event = new Event(name, startDate, endDate);
            list.add(event);
            count++;
            saveTask(FILE_PATH, list);
            System.out.printf("%s\nGot it. I've added this task:\n%s\nNow you have %d tasks in the list\n%s\n",
                    LINE, event, count, LINE);
        } catch (IOException e) {
            throw new YeetManException(e.getMessage());
        }
    }

    private static void handleDelete(String details) throws YeetManException {
        try {
            int index = Integer.parseInt(details) - 1;
            Task task = list.get(index);
            list.remove(index);
            count--;
            saveTask(FILE_PATH, list);
            System.out.printf("%s\nI've removed this task:\n\t%s\nNow you have %d tasks in your list.\n%s\n",
                    LINE, task, count, LINE);
        } catch (IOException e) {
            throw new YeetManException("Enter the task number you want to delete Uce!");
        }
    }

    private static void saveTask(String filePath, ArrayList<Task> list) throws IOException {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        FileWriter fw  = new FileWriter(filePath);
        for (Task task : list) {
            fw.write(task.toString());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    private static void handleIO() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            input = scanner.nextLine();
            try {
                String command = input.split(" ")[0];
                String details = input.split(" ").length == 1 ? "" : input.split(" ", 2)[1].trim();
                switch (command) {
                    case "list":
                        outputDisplay(list);
                        break;
                    case "bye":
                        System.out.println(LINE + "\nBYE! 4 LETTERS, 1 WORD. UH UH, YEET!\n" + LINE);
                        return;
                    case "mark": {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        list.get(index).markAsDone();
                        System.out.printf("%s\nGreat job Uce! I've marked this task as done: \n%s\n%s\n", LINE, list.get(index), LINE);
                        break;
                    }
                    case "unmark": {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        list.get(index).markAsUndone();
                        System.out.printf("%s\nI've marked this task as not done yet: \n%s\n%s\n", LINE, list.get(index), LINE);
                        break;
                    }
                    case "todo" : {
                        handleToDo(details);
                        break;
                    }
                    case "deadline":
                        handleDeadline(details);
                        break;
                    case "event":
                        handleEvent(details);
                        break;
                    case "delete":
                        handleDelete(details);
                        break;
                    default:
                        throw new YeetManException("You good Uce? This makes no sense!");
                }
            } catch (YeetManException e) {
                System.out.printf("%s\n%s\n%s\n", LINE, e.getMessage(), LINE);
            }
        }
    }

    private static void outputDisplay(ArrayList<Task> list) {
        String outputList = "";
        String header = "Here are the tasks in your list, Uce! :";
        for (Task task : list) {
            outputList += String.format("%d. %s\n", list.indexOf(task) + 1, task);
        }
        System.out.printf("%s\n%s\n%s%s\n", LINE, header, outputList, LINE);
    }

    public static void main(String[] args) {
        String greeting = String.format("%s\nHello! I'm YeetMan. It's just me Uce!\n" +
                "What can I do for you?\n%s\n", LINE, LINE);
        System.out.println(greeting);
        handleIO();
    }
}