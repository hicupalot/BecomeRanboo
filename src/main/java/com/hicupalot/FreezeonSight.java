package com.hicupalot;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerEvent;

import java.util.HashMap;
import java.util.UUID;

public class FreezeonSight implements Listener {
    private HashMap<UUID, Boolean> Freeze = new HashMap<UUID, Boolean>();

    @EventHandler
    public void OnSight(SignChangeEvent e) {
        if (e.getPlayer().hasPermission("becomeranboo.freezelook")) {
            if (e.line(1).toString().equals("Ranboo :)")) {
                Freeze.put(e.getPlayer().getUniqueId(), true);
                if (Freeze.containsKey(e.getPlayer().getUniqueId())) {
                    Entity entity = e.getPlayer().getTargetEntity(10, false);
                    assert entity != null;
                    if (entity.getType().equals(EntityType.PLAYER) || entity.getType().equals(EntityType.ZOMBIE) && !entity.hasPermission("becomeranboo.immunuefreeze")) {
                        entity.teleport(entity);
                        if (e.line(1).toString().equals("Ranboo :(")) {
                            Freeze.remove(e.getPlayer().getUniqueId(), true);
                        }
                    }
                }
            }
        }
    }
}
