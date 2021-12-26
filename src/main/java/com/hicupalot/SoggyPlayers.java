package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class SoggyPlayers extends BukkitRunnable {
    HashMap<UUID, Boolean> Warned = new HashMap<UUID, Boolean>();
    private final JavaPlugin plugin;

    public SoggyPlayers(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void run() {
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (players.isEmpty()) {
                return;
            }
            if (players.hasPermission("becomeranboo.ender")) {
                if (players.isSwimming()) { // If the player is swimming
                    players.damage(1.5); // Damage the player
                    if (!Warned.containsKey(players.getUniqueId())) {
                        players.sendMessage(ChatColor.RED + "You are submerged in the water, get out!");
                        Warned.put(players.getUniqueId(), true);
                    } else if (players.getEyeLocation().add(0, -1, 0).getBlock().getType().equals(Material.WATER) ||
                            players.getEyeLocation().add(0, -1, 0).getBlock().getType().equals(Material.WATER_CAULDRON)) {
                        if (players.getInventory().getBoots() == null) {
                            players.damage(0.75);
                            if (!Warned.containsKey(players.getUniqueId())) {
                                players.sendMessage(ChatColor.RED + "You need to get out of the water or put on boots!");
                                Warned.put(players.getUniqueId(), true);
                            } else if (!players.getInventory().getBoots().getItemMeta().getAttributeModifiers().containsKey(Attribute.GENERIC_ARMOR)) {
                                players.damage(0.75);
                                if (!Warned.containsKey(players.getUniqueId())) {
                                    players.sendMessage(ChatColor.RED + "You need to get out of the water or put on boots!");
                                    Warned.put(players.getUniqueId(), true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
