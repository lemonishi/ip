import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> loadedTasks) {
        this.tasks = loadedTasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

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
