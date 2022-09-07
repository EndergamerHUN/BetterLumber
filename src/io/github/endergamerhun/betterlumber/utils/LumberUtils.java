package io.github.endergamerhun.betterlumber.utils;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class LumberUtils {
    private final static List<Material> WOOD_TYPES = new ArrayList<>();
    private final static List<Material> TOOL_TYPES = new ArrayList<>();

    public static void init() {
        FileConfiguration config = Utils.getConfig();
        for (String wood: config.getStringList("wood-types")) {
            Material material = Material.getMaterial(wood);
            if (material != null) WOOD_TYPES.add(material);
        }
        for (String wood: config.getStringList("tool-types")) {
            Material material = Material.getMaterial(wood);
            if (material != null) TOOL_TYPES.add(material);
        }
    }

    public static List<Material> getWoodTypes() {
        return WOOD_TYPES;
    }
    public static List<Material> getToolTypes() {
        return TOOL_TYPES;
    }
}
