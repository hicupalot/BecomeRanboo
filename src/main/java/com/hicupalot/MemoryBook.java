package com.hicupalot;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class MemoryBook implements Listener {
    @EventHandler
    public void Join(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (e.getPlayer().hasPermission("becomeranboo.memorybook")){
            PlayerInventory inventory = p.getInventory();
            inventory.setItem(EquipmentSlot.OFF_HAND, new ItemStack(Material.WRITABLE_BOOK));
        }
    }
}
