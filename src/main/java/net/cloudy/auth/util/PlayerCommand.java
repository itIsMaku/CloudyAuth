package net.cloudy.auth.util;

import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand implements CommandExecutor {

    @Getter
    private final String commandName;

    public PlayerCommand(String commandName) {
        this.commandName = commandName;
    }

    public abstract boolean onCmd(Player player, String cmd, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) return true;
        onCmd((Player) sender, commandLabel, args);
        return false;
    }
}