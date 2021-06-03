package com.hicupalot;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.UUID;

public class MemoryBook implements Listener {
    private HashMap<UUID, Boolean> MemoryBook = new HashMap<UUID, Boolean>();
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
    @EventHandler
    public void Command (PlayerCommandPreprocessEvent e){
        if (e.getPlayer().hasPermission("becomeranboo.memorybook")) {
            if (MemoryBook.containsKey(e.getPlayer().getUniqueId())) {
                MemoryBook.remove(e.getPlayer().getUniqueId());
                e.getPlayer().sendMessage(ChatColor.RED + "Rejoin the server for the new memory book to be awarded");
            }
        }
                }
            }

