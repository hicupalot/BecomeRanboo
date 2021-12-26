package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class Weather extends BukkitRunnable implements Listener {
    HashMap<UUID,Boolean> Warned = new HashMap<UUID,Boolean>();
    private final JavaPlugin plugin;
    public Weather(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public void run() {
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (players.isEmpty()) {
                return;
            }
            if (!players.getWorld().isClearWeather()) {
                assert (players.getInventory().getHelmet() != null);
                if (players.hasPermission("becomeranboo.ender") && !players.getInventory().getHelmet().getType().isItem()) {
                    if (players.getLocation().getBlockY() > players.getWorld().getHighestBlockYAt(players.getLocation()))
                        players.damage(0.5);
                }
                 if (!Warned.containsKey(players.getUniqueId())) {
                     players.sendMessage(ChatColor.RED + "You are in the rain, you should seak shelter!");
                     return;
                 }
                 else if (Warned.get(players.getUniqueId())) {
                     return;
                 }
            }
        }
    }
}

