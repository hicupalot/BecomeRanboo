package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class FreezeonSight implements Listener {
    private HashMap<UUID, Boolean> Freeze = new HashMap<UUID, Boolean>();

    @EventHandler
    public void OnSight(AsyncPlayerChatEvent e) {
        if (e.getPlayer().hasPermission("becomeranboo.freezelook")) {
            if (e.getMessage().equals("Freeze") && !Freeze.containsKey(e.getPlayer().getUniqueId())){
                Freeze.put(e.getPlayer().getUniqueId(), true);
                if (Freeze.containsKey(e.getPlayer().getUniqueId())) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        while (e.getPlayer().hasLineOfSight(players)) {
                            players.setWalkSpeed(0);
                            break;
                        }
                    }
                    if (e.getMessage().equals("Freeze") && Freeze.containsKey(e.getPlayer().getUniqueId())){
                    Freeze.remove(e.getPlayer().getUniqueId(), true);
                        }
                    }
                }
            }
        }
    }
