package com.hicupalot;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.graalvm.compiler.nodeinfo.StructuralInput;

public final class BecomeRanboo extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        System.out.println(ChatColor.GOLD + "[BecomeRanboo] Beginning to Load");
        getServer().getPluginManager().registerEvents(new EndermanSounds(), this);
        getServer().getPluginManager().registerEvents(new SilkHand(), this);
        getServer().getPluginManager().registerEvents(new FreezeonSight(), this);
        getServer().getPluginManager().registerEvents(new EnderScare(), this);
        getServer().getPluginManager().registerEvents(new MemoryBook(), this);
        getServer().getPluginManager().registerEvents(new WaterDamage(), this);
        System.out.println(ChatColor.GOLD + "[BecomeRanboo] Loaded");
    }

    @Override
    public void onDisable() {
     System.out.println(ChatColor.GOLD + "[BecomeRanboo] Sleepy Ranboo going to bed now night night :>");
        // Plugin shutdown logic
    }
}
