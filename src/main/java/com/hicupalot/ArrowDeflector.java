package com.hicupalot;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowDeflector implements Listener {
    @EventHandler
    public void ArrowHit(ProjectileHitEvent e){
        if (e.getEntity().hasPermission("becomeranboo.arrowdeflect")){
            e.getEntity().setBounce(true);
        }
    }
}
