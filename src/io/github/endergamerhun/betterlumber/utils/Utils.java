package io.github.endergamerhun.betterlumber.utils;

import io.github.endergamerhun.betterlumber.BetterLumber;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class Utils {

    private static final String PREFIX = "§8[§6Better§aLumber§8]§f ";

    public static void log(String format, Object... objects) {
        final String log = String.format(format, objects);
        Bukkit.getConsoleSender().sendMessage(PREFIX + log);
    }

    public static FileConfiguration getConfig() {
        return BetterLumber.getInstance().getConfig();
    }
}
