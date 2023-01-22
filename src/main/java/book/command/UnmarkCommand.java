package book.command;

import book.Storage;
import book.TaskList;
import book.Ui;
import book.exception.SaveException;
import book.task.Task;

/**
 * Implementation of a {@code Command} for unmarking a {@code Task} object in {@code TaskList}.
 */
public class UnmarkCommand extends Command {
    /** The {@code int} 0-based index of the {@code Task} to be marked. */
    private int index;

    /**
     * Initializes a {@code UnmarkCommand} object.
     * @param index {@code int} 1-based index of the {@code Task} to be unmarked.
     */
    public UnmarkCommand(int index) {
        this.index = index - 1;
    }

    /**
     * Unmarks the {@code Task} at the associated {@code int} index in the {@code TaskList} as
     * complete and updates the {@code Storage}, prints the relevant output to the {@code Ui}.
     * @param storage {@code Storage} associated with the {@code Command}.
     * @param list {@code TaskList} associated with the {@code Command}.
     * @param ui {@code Ui} associated with the {@code Command}.
     * @throws SaveException if an error occurs with updating the {@code Storage}.
     */
    @Override
    public void execute(Storage storage, TaskList list, Ui ui) throws SaveException {
        Task task = list.get(index);
        storage.save(list);
        task.unmark();
        ui.showUnmark(task);
    }
}
