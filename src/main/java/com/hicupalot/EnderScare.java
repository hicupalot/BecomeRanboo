package com.hicupalot;

import org.bukkit.ChatColor;
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
        else if (e.getEntity().getType().equals(EntityType.ENDER_DRAGON)) {
                if (e.getTarget().hasPermission("becomeranboo.dragonimmune") && e.getTarget().getType().equals(EntityType.PLAYER)) {
                    e.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void EnderDamage(EntityDamageByEntityEvent e) { //Can't be too careful
        if (e.getEntity().hasPermission("becomeranboo.enderimmune") && e.getEntity().getType().equals(EntityType.PLAYER)) {
            if (e.getDamager().getType().equals(EntityType.ENDERMITE) || e.getDamager().getType().equals(EntityType.ENDERMAN)) {
                e.setCancelled(true);
            } else if (e.getDamager().getType().equals(EntityType.ENDER_DRAGON)) {
                if (e.getEntity().hasPermission("becomeranboo.dragonimmune") && e.getEntity().getType().equals(EntityType.PLAYER)) {
                    e.setCancelled(true);
                }
            } else if (e.getDamager().getType().equals(EntityType.PLAYER) && e.getDamager().hasPermission("becomeranboo.enderimmune")) {
                if (e.getEntity().getType().equals(EntityType.ENDERMAN) || e.getEntity().getType().equals(EntityType.ENDERMITE)) {
                    e.getDamager().sendMessage(ChatColor.RED + "You can't hurt your friends!!");
                    e.setCancelled(true);
                } else if (e.getDamager().getType().equals(EntityType.PLAYER) && e.getDamager().hasPermission("becomeranboo.dragonimmune")) {
                    if (e.getEntity().getType().equals(EntityType.ENDER_DRAGON)) {
                        e.getDamager().sendMessage(ChatColor.RED + "You can't hurt your friends!");
                        e.setCancelled(true);

                    }
                }
            }
        }
    }
}