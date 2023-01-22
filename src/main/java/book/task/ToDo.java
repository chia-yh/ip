package book.task;

public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String saveString() {
        return "T;" + this.isDone + ";" + this.description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}