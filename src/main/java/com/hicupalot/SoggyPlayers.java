package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class SoggyPlayers extends BukkitRunnable {
    HashMap<UUID, Boolean> WarnedSwim = new HashMap<UUID, Boolean>();
    HashMap<UUID, Boolean> WarnedStand = new HashMap<UUID, Boolean>();
    private final JavaPlugin plugin;

    public SoggyPlayers(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void run() {
        //    System.out.println("SoggyPlayers is running"); //debug
        if (Bukkit.getOnlinePlayers().isEmpty()) { //Checks if playerlist is empty
            return;
        }
        //   System.out.println("Player is online"); //debug
        for (Player player : Bukkit.getOnlinePlayers()) { // For each player online
            if (!player.hasPermission("becomeranboo.ender")) {
                return;
            }
            if (!player.getGameMode().equals(GameMode.SURVIVAL) && !player.getGameMode().equals(GameMode.ADVENTURE)) { //Checks if gamemode is survival or adventure
                return;
            }
            if (player.isSwimming()) { // If the player is swimming
                 player.damage(1.5); // Damage the player
                 if (!WarnedSwim.containsKey(player.getUniqueId())) {
                     player.sendMessage(ChatColor.RED + "You are submerged in the water, get out!");
                     WarnedSwim.put(player.getUniqueId(), true);
                    // System.out.println("Player is swimming"); //debug
                 }
                 return;
            }
            if (player.getInventory().getBoots() != null) {
              //  System.out.println("Player has boots"); //debug
                return;
            }
            if (player.getEyeLocation().add(0, -1, 0).getBlock().getType().equals(Material.WATER)) {  // Checks if chest is in cauldron
              //  System.out.println("Player is in water"); //debug
                player.damage(0.75);
                if (!WarnedStand.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You need to get out of the water or put on boots!");
                    WarnedStand.put(player.getUniqueId(), true);
                }
            }
        }
    }
}

