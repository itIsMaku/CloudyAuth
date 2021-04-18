package net.cloudy.auth.util;

import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public abstract class ConsoleCommand implements CommandExecutor {

    @Getter
    private final String commandName;

    public ConsoleCommand(String commandName) {
        this.commandName = commandName;
    }

    public abstract boolean onCmd(ConsoleCommandSender console, String cmd, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof ConsoleCommandSender)) return true;
        onCmd((ConsoleCommandSender) sender, commandLabel, args);
        return false;
    }
}