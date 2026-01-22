import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws YeetManException {
        try {
            ArrayList<Task> loaded = new ArrayList<>();
            File file = new File(this.filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    char taskType = line.charAt(1);
                    boolean isDone = line.charAt(4) == 'X';
                    String info = line.substring(6);

                    Task task;
                    switch (taskType) {
                        case 'T':
                            task = new ToDo(info);
                            break;
                        case 'D': {
                            int endIndex = info.lastIndexOf("(by:");
                            String description = info.substring(0, endIndex).trim();
                            String dateString = info.split("by:")[1].trim().replace(")", "");
                            LocalDateTime dueDate = LocalDateTime.parse(dateString, Task.FORMATTER);
                            task = new Deadline(description, dueDate);
                            break;
                        }
                        case 'E': {
                            int endIndex = info.lastIndexOf("(from:");
                            String description = info.substring(0, endIndex).trim();
                            String startString = info.split("from:|to:")[1].trim();
                            String endString = info.split("to:")[1].trim().replace(")", "");
                            LocalDateTime startDate = LocalDateTime.parse(startString, Task.FORMATTER);
                            LocalDateTime endDate = LocalDateTime.parse(endString, Task.FORMATTER);
                            task = new Event(description, startDate, endDate);
                            break;
                        }
                        default:
                            throw new IllegalArgumentException("Can't load tasks, Uce!");
                    }

                    if (isDone) {
                        task.markAsDone();
                    }

                    loaded.add(task);
                }
            }
            scanner.close();
            return loaded;
        } catch (FileNotFoundException e) {
            throw new YeetManException("Failed to load tasks, Uce!");
        }
    }

    public void save(ArrayList<Task> tasks) throws YeetManException {
        try {
            File file = new File(this.filePath);
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            FileWriter fw = new FileWriter(this.filePath);
            for (Task task : tasks) {
                fw.write(task.toString());
                fw.write(System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new YeetManException("Invalid file path, Uce!");
        }
    }
}
