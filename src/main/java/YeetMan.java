import java.util.List;
import java.util.Scanner;

public class YeetMan {

    private static String[] list = new String[100];
    private static int count = 0;
    private static final String LINE = "____________________________________________________________";

    private static void handleIO() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("bye")) {
            input = scanner.nextLine();
            if (input.equals("list")) {
                outputDisplay(list);
            } else if (input.equals("bye")) {
                System.out.println(LINE + "\nBYE! 4 LETTERS, 1 WORD. UH UH, YEET!\n" + LINE);
                break;
            } else {
                list[count] = input;
                count++;
                String output = String.format("%s\n added: %s\n %s\n", LINE, input, LINE);
                System.out.println(output);
            }
        }
    }

    private static void outputDisplay(String[] list) {
        String outputList = "";
        for (int i = 0; i < count ; i++) {
            outputList += String.format("%d. %s\n", i + 1, list[i]);
        }
        System.out.printf("%s\n %s %s\n", LINE, outputList, LINE);
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

