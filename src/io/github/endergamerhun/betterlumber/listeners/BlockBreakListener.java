package io.github.endergamerhun.betterlumber.listeners;

import io.github.endergamerhun.betterlumber.utils.LumberUtils;
import io.github.endergamerhun.betterlumber.utils.Utils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;


public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        FileConfiguration config = Utils.getConfig();
        if (!config.getBoolean("enable")) return;

        // Check Tool
        ItemStack tool = e.getPlayer().getItemInUse();
        List<Material> acceptedTools = LumberUtils.getToolTypes();
        if (tool == null) {
            if (!acceptedTools.contains(Material.AIR)) return;
        } else if (!acceptedTools.contains(tool.getType())) return;

        // Check Block
        Block block = e.getBlock();
        if (!LumberUtils.getWoodTypes().contains(block.getType())) return;

        // Start Break
        breakBlock(block, block, e.getPlayer());

    }

    private boolean breakBlock(Block block, Block caller, Player player) {
        FileConfiguration config = Utils.getConfig();
        if (config.getBoolean("allow-mixed-wood")) {
            if (!LumberUtils.getWoodTypes().contains(block.getType())) return false;
        } else if (block.getType() != caller.getType()) return false;
        block.breakNaturally(player.getItemInUse());
        // TODO: Loop all nearby blocks -caller
        return true;
    }
}
