package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Weather extends BukkitRunnable implements Listener {
    private static final List<Biome> noRainBiome = new ArrayList<>();
    private final JavaPlugin plugin;
    HashMap<UUID, Boolean> Warned = new HashMap<>();

    public Weather(JavaPlugin plugin) {
        noRainBiome.add(Biome.BADLANDS);
        noRainBiome.add(Biome.WOODED_BADLANDS);
        noRainBiome.add(Biome.ERODED_BADLANDS);
        noRainBiome.add(Biome.DESERT);
        noRainBiome.add(Biome.SAVANNA);
        noRainBiome.add(Biome.WINDSWEPT_SAVANNA);
        noRainBiome.add(Biome.SAVANNA_PLATEAU);
        this.plugin = plugin;
    }

    public void run() {

        //    System.out.println("Weather is running"); //debug
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
            //    System.out.println("Clear is " + player.getWorld().isClearWeather()); //debug
            //     System.out.println("Storm is " + player.getWorld().hasStorm()); //debug
            //    System.out.println("Thundering is " + player.getWorld().isThundering());  //debug
            if (player.getWorld().isClearWeather()) { // Checks if player is not in rain
                //   System.out.println("Weather is clear"); //debug
                return;
            }
            if (noRainBiome.contains(player.getWorld().getBiome(player.getLocation()))) {
                //     System.out.println(player.getName() + " is in a biome with no rain!"); //debug
                return;
            }
            if (player.getInventory().getHelmet() != null) {
                return;
            }
            //     System.out.println("Player is ender and has no helmet"); //debug
            if (player.getLocation().getBlockY() < player.getWorld().getHighestBlockYAt(player.getLocation().getBlockX(), player.getLocation().getBlockZ())) {
                return;
            }
            //    System.out.println("Player is above highest block"); //debug
            player.damage(0.5);
            if (!Warned.containsKey(player.getUniqueId())) {
                player.sendMessage(ChatColor.RED + "You are in rain! You should seek shelter!");
                Warned.put(player.getUniqueId(), true);
                return;
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Warned.remove(e.getPlayer().getUniqueId());
    }
}