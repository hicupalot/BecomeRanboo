package com.hicupalot;

import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

import java.util.HashMap;
import java.util.UUID;

public class WaterDamage implements Listener {
    private HashMap<UUID, Long> Rain = new HashMap<UUID, Long>();
    private HashMap<UUID, Long> Underwater = new HashMap<UUID, Long>();
    private int WaterDamage = 10;

    @EventHandler
    public void Rain(PlayerEvent e) {
        Player p = e.getPlayer();
        if (e.getPlayer().hasPermission("becomeranboo.waterdamage")) {
            if (e.getPlayer().getPlayerWeather().equals(WeatherType.DOWNFALL) && !e.getPlayer().getInventory().getHelmet().getType().isItem()) {
                e.getPlayer().damage(0);
                Rain.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
                if (Rain.containsKey(p.getUniqueId())) {
                    long rainsecondsleft = (System.currentTimeMillis() - Rain.get(p.getUniqueId()));
                    if (rainsecondsleft <= 0) {
                        e.getPlayer().damage(0);
                    }
                }
            }
        }
    }

    @EventHandler
    public void Underwater(PlayerEvent e) {
        Player p = e.getPlayer();
        if (e.getPlayer().hasPermission("becomeranboo.waterdamage")) {
            if (e.getPlayer().isInWater()) {
                if (e.getPlayer().getInventory().getHelmet().getType().isItem()) {
                    if (e.getPlayer().getInventory().getBoots().getType().isItem()) {
                        if (e.getPlayer().getInventory().getChestplate().getType().isItem()) {
                            if (e.getPlayer().getInventory().getLeggings().getType().isItem()) {
                                e.getPlayer().damage(2);
                                Underwater.put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
                                if (Underwater.containsKey(p.getUniqueId())) {
                                    long underwatersecondsleft = (System.currentTimeMillis() - Underwater.get(p.getUniqueId()));
                                    if (underwatersecondsleft <= 0) {
                                        e.getPlayer().damage(2);
                                    }

                                }

                            }
                        }
                    }
                }
            }
        }
    }
}