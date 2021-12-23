package com.hicupalot;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;

public class EnderScare implements Listener {
    @EventHandler
    public void EnderTarget(EntityTargetEvent e) {
        if (e.getTarget()==null){
            return;
        }
        if (e.getTarget().hasPermission("becomeranboo.enderimmune") && e.getTarget().getType().equals(EntityType.PLAYER)) {
            if (e.getEntity().getType().equals(EntityType.ENDERMAN) || e.getEntity().getType().equals(EntityType.ENDERMITE)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void EnderDragon(EntityTargetEvent e) {
        if (e.getTarget()==null){
            return;
        }
        if (e.getTarget().hasPermission("becomeranboo.dragonimmune") && e.getTarget().getType().equals(EntityType.PLAYER)) {
            if (e.getEntity().getType().equals(EntityType.ENDER_DRAGON)) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void EnderDamage(EntityDamageByEntityEvent e) { //Can't be too careful
        if (e.getEntity().hasPermission("becomeranboo.enderimmune") && e.getEntity().getType().equals(EntityType.PLAYER)) {
            if (e.getDamager().getType().equals(EntityType.ENDERMITE) || e.getDamager().getType().equals(EntityType.ENDERMAN)) {
                e.setCancelled(true);
            }
        }
    }
}