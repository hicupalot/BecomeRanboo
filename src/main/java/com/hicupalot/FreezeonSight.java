package com.hicupalot;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class FreezeonSight implements Listener {
    @EventHandler
    public void OnSight(PlayerSwapHandItemsEvent e){
        if (e.getPlayer().hasPermission("becomeranboo.freezelook")){
        Entity entity = e.getPlayer().getTargetEntity(10,false);
        if (entity.getType().equals(EntityType.PLAYER) && !entity.hasPermission("becomeranboo.immunuefreeze")){
        entity.teleport(entity.getLocation());
        }
        }
    }
}
