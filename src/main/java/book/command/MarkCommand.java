package book.command;

import book.exception.SaveException;

import book.task.Task;

import book.Storage;
import book.TaskList;
import book.Ui;

public class MarkCommand extends Command {
    private int index;
    public MarkCommand(int index) {
        this.index = index - 1;
    }
    @Override
    public void execute(Storage storage, TaskList list, Ui ui) throws SaveException {
        Task task = list.get(index);
        task.mark();
        storage.save(list);
        ui.showMark(task);
    }
}