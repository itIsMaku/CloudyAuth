package net.cloudy.auth.database.table;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bukkit.entity.Player;

@DatabaseTable(tableName = "cloudy_authplayers")
@NoArgsConstructor
@Accessors(fluent = true, chain = true)
@Data
public class AuthPlayer {

    @DatabaseField(id = true)
    private String uuid;

    @DatabaseField
    private String username;

    @DatabaseField
    private String password;


    @DatabaseField(columnName = "auto_login")
    private boolean autoLogin;

    public static AuthPlayer register(Player p, String password) {
        return new AuthPlayer().uuid(p.getUniqueId().toString()).username(p.getName()).password(password).autoLogin(false);
    }
}