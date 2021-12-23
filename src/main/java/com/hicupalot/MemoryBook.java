package com.hicupalot;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class MemoryBook implements CommandExecutor {
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
             if (sender.hasPermission("becomeranboo.memorybook")) {
                ItemStack Memory = new ItemStack(Material.WRITABLE_BOOK);
                ItemMeta meta = Memory.getItemMeta();
                 assert meta != null;
                 meta.setDisplayName(ChatColor.BLUE + "Memory Book");
                Memory.setItemMeta(meta);
                PlayerInventory inventory = ((Player) sender).getInventory();
                inventory.setItem(EquipmentSlot.OFF_HAND, Memory);
            }
        else{
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            return false;
             }
        }
    return false;
        }
}