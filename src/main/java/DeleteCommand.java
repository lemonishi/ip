public class DeleteCommand extends Command {
    public DeleteCommand(String info) {
        super(info);
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(info);
            tasks.deleteTask(taskNumber);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to delete, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
