package com.hicupalot;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Random;

public class EndermanSounds implements Listener {
    int max = 10;
    int min = 1;
    @EventHandler
    public void Genderman(AsyncPlayerChatEvent e) {
        if (e.getPlayer().hasPermission("becomeranboo.ender")) {
            int i = (int)Math.floor(Math.random()*(max-min+1)+min);
            if (i == 1) { // 10% chance
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 10,1);
            }
        }
    }
}