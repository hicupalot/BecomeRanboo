package com.hicupalot;

import com.hicupalot.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class BecomeRanboo extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println(ChatColor.GOLD + "[BecomeRanboo] Beginning to Load");
        getServer().getPluginManager().registerEvents(new EndermanSounds(), this);
        getServer().getPluginManager().registerEvents(new SilkHand(), this);
        getServer().getPluginManager().registerEvents(new FreezeonSight(), this);
        getServer().getPluginManager().registerEvents(new EnderScare(), this);
        getServer().getPluginManager().registerEvents(new Weather(this), this);
        BukkitTask checkRain = new Weather(this).runTaskTimer(this, 100, 100);
        BukkitTask checkWater = new SoggyPlayers(this).runTaskTimer(this, 100, 100);
        getCommand("memory").setExecutor(new MemoryBook());
        System.out.println(ChatColor.GOLD + "[BecomeRanboo] Loaded");
    }

    @Override
    public void onDisable() {
     System.out.println(ChatColor.GOLD + "[BecomeRanboo] Sleepy Ranboo going to bed now night night :>");
    }
}
