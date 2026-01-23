public class UnmarkCommand extends Command {
    public UnmarkCommand(String info) {
        super(info);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws YeetManException {
        try {
            int taskNumber = Integer.parseInt(info);
            Task unmarked = tasks.getTask(taskNumber - 1);
            unmarked.markAsUndone();
            storage.save(tasks);
            ui.showUnmarkMessage(unmarked);
        } catch (NumberFormatException e) {
            throw new YeetManException("Enter the task number you want to mark as undone, Uce!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
