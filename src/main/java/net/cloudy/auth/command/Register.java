package net.cloudy.auth.command;

import net.cloudy.auth.database.table.AuthPlayer;
import net.cloudy.auth.util.PlayerCommand;
import org.bukkit.entity.Player;

public class Register extends PlayerCommand {

    public Register() {
        super("register");
    }

    @Override
    public boolean onCmd(Player p, String cmd, String[] args) {
        if (args.length < 1) {
            p.sendMessage("§8[§aAuth§8] §7Register with this command: §e'/register <password> <password>'");
            return true;
        }
        if (args.length < 2) {
            p.sendMessage("§8[§aAuth§8] §7Register with this command: §e'/register <password> <password>'");
            return true;
        }
        if (!args[1].equalsIgnoreCase(args[0])) {
            p.sendMessage("§8[§aAuth§8] §7Passwords are not same!");
            return true;
        }
        if (args[0].length() < 5) {
            p.sendMessage("§8[§aAuth§8] §7The password must be at least 5 characters long!");
            return true;
        }
        if (args[0].length() > 30) {
            p.sendMessage("§8[§aAuth§8] §7The password can have a maximum of 30 characters!");
            return true;
        }
        p.sendMessage("§8[§aAuth§8] §aYou have been successfully registered!");
        AuthPlayer.register(p, args[0]);
        return false;
    }
}
