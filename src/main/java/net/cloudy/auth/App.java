package net.cloudy.auth;

import com.j256.ormlite.jdbc.JdbcSingleConnectionSource;
import lombok.Getter;
import net.cloudy.auth.command.Register;
import net.cloudy.auth.database.MySQL;
import net.cloudy.auth.listener.PlayerEvents;
import net.cloudy.auth.util.Command;
import net.cloudy.auth.util.Console;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;

public class App extends JavaPlugin {

    @Getter
    private static App instance;
    @Getter
    private MySQL mySQL;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        initDatabase();
        Command.registerCommand(new Register());
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);

        Console.log("§9CloudyAuth was enabled.");
    }

    @Override
    public void onDisable() {
        Console.log("§cCloudyAuth was disabled.");
    }

    private void initDatabase() {
        mySQL = new MySQL();
        try {
            mySQL.connect();
        } catch (SQLException e) {
            Console.log(Level.SEVERE, "Can't connect to MySQL...");
            e.printStackTrace();
        }
    }
}
