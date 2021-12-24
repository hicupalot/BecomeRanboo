package com.hicupalot;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Random;

public class EndermanSounds implements Listener {
    int max = 10;
    int min = 1;
    int diff = max - min;
    Random rn = new Random();
    int i2 = min;

    @EventHandler
    public void Genderman(AsyncPlayerChatEvent e) {
        if (e.getPlayer().hasPermission("becomeranboo.ender")) {
            int i = rn.nextInt(diff + 1);
            if (i == 10) {
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 10, 29);
            }
        }
    }
}