public class UnmarkCommand extends Command {
    private int index;
    public UnmarkCommand(int index) {
        this.index = index - 1;
    }
    @Override
    public void execute(Storage storage, TaskList list, Ui ui) throws SaveException {
        Task task = list.get(index);
        storage.save(list);
        task.unmark();
        ui.showUnmark(task);
    }
}
