package net.cloudy.auth.util;

import net.cloudy.auth.App;

public class Command {

    public static void registerCommand(PlayerCommand command) {
        App.getInstance().getCommand(command.getCommandName()).setExecutor(command);
        Console.log("§aPlayer command " + command.getCommandName() + " was registered.");
    }

    public static void registerCommand(ConsoleCommand command) {
        App.getInstance().getCommand(command.getCommandName()).setExecutor(command);
        Console.log("§aConsole command " + command.getCommandName() + " was registered.");
    }

}
