public class MarkCommand extends Command {
    public MarkCommand(String info) {
        super(info);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(info);
            Task marked = tasks.getTask(taskNumber - 1);
            marked.markAsDone();
            ui.showMarkMessage(marked);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to mark as done, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
