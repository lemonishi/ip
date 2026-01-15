import java.util.Scanner;

public class YeetMan {

    private static void handleIO() {
        String line = "____________________________________________________________";
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!input.equals("bye")) {
            while (!input.equals("bye")) {
                String output = String.format("%s\n %s\n %s\n", line, input, line);
                System.out.println(output);
                input = scanner.nextLine();
            }
            System.out.println(line + "\nbye\n" + line);
        } else {
            System.out.println(line + "\nbye\n" + line);
        }
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

