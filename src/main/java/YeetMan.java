import java.util.List;
import java.util.Scanner;

public class YeetMan {

    private static Task[] list = new Task[100];
    private static int count = 0;
    private static final String LINE = "____________________________________________________________";

    private static void handleIO() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            input = scanner.nextLine();
            String command = input.split(" ")[0];
            if (command.equals("list")) {
                outputDisplay(list);
            } else if (command.equals("bye")) {
                System.out.println(LINE + "\nBYE! 4 LETTERS, 1 WORD. UH UH, YEET!\n" + LINE);
                break;
            } else if (command.equals("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                list[index].markAsDone();
                System.out.printf("%s\nGreat job Uce! I've marked this task as done: \n%s\n%s\n", LINE, list[index], LINE);
            } else if (command.equals("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                list[index].markAsUndone();
                System.out.printf("%s\nI've marked this task as not done yet: \n%s\n%s\n", LINE, list[index], LINE);
            } else {
                String details = input.split(" ", 2)[1].trim();
                switch (command) {
                    case "todo":
                        ToDo todo = new ToDo(details);
                        list[count] = todo;
                        count++;
                        System.out.printf("%s\nGot it. I've added this task:\n%s\nNow you have %d tasks in the list\n%s\n",
                                LINE, todo, count, LINE);
                        break;
                    case "deadline": {
                        String name = details.split("/by")[0].trim();
                        String dueDate = details.split("/by")[1].trim();
                        Deadline deadline = new Deadline(name, dueDate);
                        list[count] = deadline;
                        count++;
                        System.out.printf("%s\nGot it. I've added this task:\n%s\nNow you have %d tasks in the list\n%s\n",
                                LINE, deadline, count, LINE);
                        break;
                    }
                    case "event": {
                        String name = details.split("/from")[0].trim();
                        String startDate = details.split("/from|/to")[1].trim();
                        String endDate = details.split("/to")[1].trim();
                        Event event = new Event(name ,startDate, endDate);
                        list[count] = event;
                        count++;
                        System.out.printf("%s\nGot it. I've added this task:\n%s\nNow you have %d tasks in the list\n%s\n",
                                LINE, event, count, LINE);
                        break;
                    }
                    default:
                        list[count] = new Task(input);
                        count++;
                        String output = String.format("%s\n added: %s\n %s\n", LINE, input, LINE);
                        System.out.println(output);
                }
            }
        }
    }

    private static void outputDisplay(Task[] list) {
        String outputList = "";
        String header = "Here are the tasks in your list, Uce! :";
        for (int i = 0; i < count ; i++) {
            outputList += String.format("%d. %s\n", i + 1, list[i]);
        }
        System.out.printf("%s\n %s\n %s %s\n", LINE, header, outputList, LINE);
    }

    public static void main(String[] args) {
        String greeting = "____________________________________________________________\n" +
                "Hello! I'm YeetMan. It's just me Uce!\n" +
                " What can I do for you?\n" +
                "____________________________________________________________";
        System.out.println(greeting);
        handleIO();
    }
}

