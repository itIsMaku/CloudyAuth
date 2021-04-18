package net.cloudy.auth.database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import lombok.Getter;
import net.cloudy.auth.App;
import net.cloudy.auth.database.table.AuthPlayer;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;
import java.sql.SQLException;

public class MySQL {

    @Getter
    protected FileConfiguration config;
    @Getter
    private ConnectionSource source;

    public MySQL() {
        config = App.getInstance().getConfig();
    }

    public void connect() throws SQLException {
        String username = config.getString("mysql.username");
        String password = config.getString("mysql.password");
        String database = config.getString("mysql.database");
        String address = config.getString("mysql.address");
        int port = config.getInt("mysql.port");
        boolean ssl = config.getBoolean("mysql.ssl");
        boolean autoReconnect = config.getBoolean("mysql.autoReconnect");
        source = new JdbcConnectionSource(String.format("jdbc:mysql://%s:%s@%s:%s/%s?autoReconnect=%s&useSSL=%s", username, password, address, port, database, autoReconnect, ssl));

        TableUtils.createTableIfNotExists(source, AuthPlayer.class);
    }

    public void disconnect() throws IOException {
        source.close();
    }

}
