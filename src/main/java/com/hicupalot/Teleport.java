package com.hicupalot;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Teleport implements Listener {
    @EventHandler
    public void Teleport(AsyncPlayerChatEvent e){
        if (e.getPlayer().hasPermission("becomeranoo.teleportspecific")){
        if (e.getMessage().equals("poof")|| e.getMessage().equals("teleport")){
            e.getPlayer().getTargetBlockExact(100);
        e.getPlayer().teleport((Location) e.getPlayer().getTargetBlockExact(100));
        e.getPlayer().getEyeLocation().getBlock().setType(Material.AIR);
        }
        }
    }
}
