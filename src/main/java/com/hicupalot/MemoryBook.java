package com.hicupalot;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.UUID;

public class MemoryBook implements Listener, CommandExecutor {
    private HashMap<UUID, Boolean> MemoryBook = new HashMap<UUID, Boolean>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("becomeranboo.memorybook")) {
            MemoryBook.remove(sender.getServer().getPlayer(String.valueOf(sender)).getUniqueId());
            sender.sendMessage(ChatColor.GOLD + "Please region to recieve another Memory Book, this will appear in your off" +
                    "so please make sure this slot is clear");
        }
    return false;
    }
    @EventHandler
    public void Join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (e.getPlayer().hasPermission("becomeranboo.memorybook")) {
            if (!MemoryBook.containsKey(e.getPlayer().getUniqueId())) {
                ItemStack Memory = new ItemStack(Material.WRITABLE_BOOK);
                ItemMeta meta = Memory.getItemMeta();
                meta.setDisplayName(ChatColor.BLUE+"Memory Book");
                Memory.setItemMeta(meta);
                PlayerInventory inventory = p.getInventory();
                inventory.setItem(EquipmentSlot.OFF_HAND, Memory);
                MemoryBook.put(e.getPlayer().getUniqueId(), true);
            }

        }
    }
}
