package com.hicupalot;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EnderScare implements Listener {
    @EventHandler
    public void Ender(EntityDamageByEntityEvent e) {
        if (e.getEntity().hasPermission("becomeranboo.enderimmune") && e.getEntity().getType().equals(EntityType.PLAYER)) {
            if (e.getDamager().getType().equals(EntityType.ENDERMAN)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void EnderDragon(EntityDamageByEntityEvent e) {
        if (e.getEntity().hasPermission("becomeranboo.dragonimmune") && e.getEntity().getType().equals(EntityType.PLAYER)) {
            if (e.getDamager().getType().equals(EntityType.ENDER_DRAGON)) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void AntiCheat(EntityDamageByEntityEvent e){
        if (e.getDamager().hasPermission("becomeranboo.anticheatender")){
            if (e.getEntityType().equals(EntityType.ENDER_DRAGON) || e.getEntityType().equals(EntityType.ENDERMAN) || e.getEntityType().equals(EntityType.ENDERMITE)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void Endermite(EntityDamageByEntityEvent e) {
        if (e.getEntity().hasPermission("becomeranboo.enderimmune") && e.getEntity().getType().equals(EntityType.PLAYER)) {
            if (e.getDamager().getType().equals(EntityType.ENDERMITE)) {
                e.setCancelled(true);
            }
        }
    }
}