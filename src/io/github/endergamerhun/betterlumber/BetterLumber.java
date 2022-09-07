package io.github.endergamerhun.betterlumber;

import io.github.endergamerhun.betterlumber.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterLumber extends JavaPlugin {

    private static BetterLumber INSTANCE;

    public static BetterLumber getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;
        Utils.log("Plugin loaded");
    }

    @Override
    public void onDisable() {
        Utils.log("Plugin unloaded");
    }
}
