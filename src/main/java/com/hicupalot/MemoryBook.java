package com.hicupalot;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.UUID;

public class MemoryBook implements CommandExecutor {
    HashMap<UUID, Boolean> Confirm = new HashMap<UUID, Boolean>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("becomeranboo.memorybook")) {
                if (Confirm.containsKey(((Player) sender).getUniqueId())) {
                    ItemStack Memory = new ItemStack(Material.WRITABLE_BOOK);
                    ItemMeta meta = Memory.getItemMeta();
                    assert meta != null;
                    meta.setDisplayName(ChatColor.BLUE + "Memory Book");
                    Memory.setItemMeta(meta);
                    PlayerInventory inventory = ((Player) sender).getInventory();
                    inventory.setItem(EquipmentSlot.OFF_HAND, Memory);
                    Confirm.remove(((Player) sender).getUniqueId());
                } else if (!Confirm.containsKey(((Player) sender).getUniqueId())) {
                    Confirm.put(((Player) sender).getUniqueId(), true);
                    sender.sendMessage(ChatColor.RED + "Are you sure you want to make a memory book (IN YOUR OFF-HAND)? Type /memorybook again to confirm.");
                } else {
                    sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                    return false;
                }
            }
        }
    return false;
    }
}