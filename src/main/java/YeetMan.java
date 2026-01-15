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
                list[count] = new Task(input);
                count++;
                String output = String.format("%s\n added: %s\n %s\n", LINE, input, LINE);
                System.out.println(output);
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

