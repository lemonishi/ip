public class DeleteCommand extends Command {
    public DeleteCommand(String info) {
        super(info);
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(info);
            Task deleted = tasks.getTask(taskNumber - 1);
            tasks.deleteTask(taskNumber);
            storage.save(tasks);
            ui.showDeleteMessage(deleted, tasks);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to delete, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
