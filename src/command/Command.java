package command;

public interface Command {
    void execute(String params);
    String getCommandName();
    default String getDesc() {
        return "null";
    }
}
