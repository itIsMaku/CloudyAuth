package net.cloudy.auth.listener;

import net.cloudy.auth.App;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.Arrays;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        for (int i = 0; i <= 50; i++) p.sendMessage(" ");
        p.teleport(new Location(Bukkit.getWorld("world"), -268, 104, 151.5, 90, -4));
        e.setJoinMessage(null);
        p.setPlayerListName("§8");
        p.sendMessage("§8[§aGDPR§8] §7By playing on our gaming network, you agree to the collection of personal data (IP address, e-mail). If you do not agree, disconnect now. Personal data is stored only after registration.");
        p.sendMessage("§8[§aAuth§8] §7Register with this command: §e'/register <password> <password>'");
        Bukkit.getScheduler().runTaskTimer(App.getInstance(), () -> p.sendMessage("§8[§aAuth§8] §7Register with this command: §e'/register <password> <password>'"), 0, 200);
        Bukkit.getScheduler().runTaskLater(App.getInstance(), () -> p.kickPlayer("§cYou are signing in too long."), 1800);
        p.getWorld().setTime(1800);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onChat(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/register") || e.getMessage().startsWith("/login")) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        e.setTo(e.getFrom());
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        e.setCancelled(true);
    }
}
