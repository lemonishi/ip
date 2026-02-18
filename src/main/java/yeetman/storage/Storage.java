package yeetman.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import yeetman.exception.YeetManException;
import yeetman.task.Deadline;
import yeetman.task.Event;
import yeetman.task.Task;
import yeetman.task.ToDo;
import yeetman.tasklist.TaskList;

/**
 * Encapsulates the persistence logic of the list of tasks.
 */
public class Storage {
    private String filePath;

    /**
     * Instantiates a new Storage instance.
     *
     * @param filePath File path to the .txt file containing the task data.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the tasks from the .txt file indicated in the file path.
     *
     * @return ArrayList of Task objects.
     * @throws YeetManException If file path is non-existent.
     */
    public ArrayList<Task> load() throws YeetManException {
        try {
            ArrayList<Task> loaded = new ArrayList<>();
            File file = new File(this.filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(" \\| ");
                    char taskType = parts[0].charAt(0);
                    boolean isDone = parts[1].equals("1");
                    String description = parts[2];

                    Task task;
                    switch (taskType) {
                    case 'T':
                        task = new ToDo(description);
                        break;
                    case 'D':
                        LocalDateTime dueDate = LocalDateTime.parse(parts[3], Task.FORMATTER);
                        task = new Deadline(description, dueDate);
                        break;
                    case 'E':
                        LocalDateTime startDate = LocalDateTime.parse(parts[3], Task.FORMATTER);
                        LocalDateTime endDate = LocalDateTime.parse(parts[4], Task.FORMATTER);
                        task = new Event(description, startDate, endDate);
                        break;
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

    /**
     * Saves all tasks in the TaskList to the .txt file in the indicated file path.
     *
     * @param tasks List of tasks.
     * @throws YeetManException If file path is invalid.
     */
    public void save(TaskList tasks) throws YeetManException {
        try {
            File file = new File(this.filePath);
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            FileWriter fw = new FileWriter(this.filePath);
            for (Task task : tasks.getTasks()) {
                fw.write(task.toSaveString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new YeetManException("Invalid file path, Uce!");
        }
    }
}
