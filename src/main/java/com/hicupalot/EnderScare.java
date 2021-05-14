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
        if (e.getEntity().hasPermission("becomeranboo.enderimmune") && e.getEntity().getType().equals(EntityType.PLAYER)) {
            if (e.getDamager().getType().equals(EntityType.ENDER_DRAGON)) {
                e.setCancelled(true);
            }
        }
    }
}