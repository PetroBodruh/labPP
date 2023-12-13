package command;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command {
    Executor executor;
    private Map<String, Command> commands = new HashMap<>();
    public HelpCommand(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void execute(String param) {
        System.out.println("executed help");
        executor.showAvailableCommands();
        }



    @Override
    public String getCommandName() {
        return "help";
    }
}
