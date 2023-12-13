package command;
import java.util.HashMap;
import java.util.Map;

public class Executor {
    private Map<String, Command> commands = new HashMap<>();

    public void addCommand(Command command) {
        commands.put(command.getCommandName(), command);
    }

    public void executeCommand(String commandName, String params) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(params);
        } else {
            System.out.println("Невірна команда");
        }
    }

    public void showAvailableCommands() {
        System.out.println("Available commands:");
        for (var element : commands.entrySet()) {
            System.out.println("- " + element.getKey() + ", " + element.getValue().getDesc());
        }
    }
}
