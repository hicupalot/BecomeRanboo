package com.hicupalot;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class BecomeRanboo extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GOLD + "[BecomeRanboo] Beginning to Load");
        getServer().getPluginManager().registerEvents(new EndermanSounds(), this);
        getServer().getPluginManager().registerEvents(new SilkHand(), this);
        getServer().getPluginManager().registerEvents(new FreezeonSight(), this);
        getServer().getPluginManager().registerEvents(new Teleport(), this);
        getServer().getPluginManager().registerEvents(new ArrowDeflector(), this);
        System.out.println(ChatColor.GOLD + "[BecomeRanboo] Loaded");
    }

    @Override
    public void onDisable() {
     System.out.println(ChatColor.GOLD + "[BecomeRanboo] Sleepy Ranboo going to bed now night night :>");
        // Plugin shutdown logic
    }
}
