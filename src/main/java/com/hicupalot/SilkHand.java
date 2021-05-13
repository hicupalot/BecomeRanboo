package com.hicupalot;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SilkHand implements Listener {
    @EventHandler
    public void BlockBreak(BlockBreakEvent e){
        if (e.getPlayer().hasPermission("becomeranboo.silkhand")){
        if (e.getPlayer().getGameMode() == GameMode.SURVIVAL){
        if (!e.getBlock().getType().equals(Material.AIR)){
        if (e.getPlayer().getActiveItem().getType()==Material.AIR){
        e.setDropItems(false);
         e.getPlayer().getWorld().dropItem(e.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
         new ItemStack(e.getBlock().getType()));
        }
        }
        }
        }
    }
}
