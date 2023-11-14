package command;

import java.util.HashMap;
        import java.util.Map;

public class Executor {
    private Map<CommandType, Command> commands = new HashMap<>();


    public void addCommand(Command command) {
        commands.put(command.getCommandName(), command);
    }

    public void executeCommand(CommandType commandName, String params) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(params);
        } else {
            System.out.println("Невірна команда");
        }
    }
}

