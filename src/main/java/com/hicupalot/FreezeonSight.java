package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.UUID;

public class FreezeonSight implements Listener {
    private HashMap<UUID, Boolean> Freeze = new HashMap<UUID, Boolean>();

    @EventHandler
    public void OnSight(AsyncPlayerChatEvent e) {
        if (e.getPlayer().hasPermission("becomeranboo.freezelook")) {
            if (e.getMessage().equals("Freeze") && !Freeze.containsKey(e.getPlayer().getUniqueId())){
                e.setCancelled(true);
                Freeze.put(e.getPlayer().getUniqueId(), true);
                if (Freeze.containsKey(e.getPlayer().getUniqueId())) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        while (e.getPlayer().hasLineOfSight(players)) {
                            players.setWalkSpeed(0);
                        }
                    }
                    if (e.getMessage().equals("Freeze") && Freeze.containsKey(e.getPlayer().getUniqueId())){
                        e.setCancelled(true);
                    Freeze.remove(e.getPlayer().getUniqueId(), true);
                        }
        else{
            e.setCancelled(false);
                    }
                    }
                }
            }
        }
    }
