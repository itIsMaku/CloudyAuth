package net.cloudy.auth.util;

import java.util.logging.Level;
import org.bukkit.Bukkit;

public class Console {

    /**
     * Print each item of an array to console
     *
     * @param out Array to output
     */
    public static <T> void log(T[] out) {
        for (T s : out) {
            log(s);
        }
    }

    /**
     * Print to console (with default Level.INFO)
     *
     * @param out String to output
     */
    public static <T> void log(T out) {
        log(Level.INFO, out);
    }

    /**
     * Print to console
     *
     * @param out String to output
     */
    public static <T> void log(Level lvl, T out) {
        Bukkit.getLogger().log(lvl, out.toString());
    }
}