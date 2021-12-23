package com.hicupalot;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class SilkHand implements Listener {
    @EventHandler
    public void BlockBreak(BlockBreakEvent e){
        if (e.getPlayer().hasPermission("becomeranboo.silkhand")) {
            if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
                if (!e.getBlock().isLiquid()) {
                    if (e.getPlayer().getItemInUse().equals(Material.AIR)){
                        e.setDropItems(false);
                        e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(),new ItemStack(e.getBlock().getType()));
                    }
                }
            }
        }
    }
}
