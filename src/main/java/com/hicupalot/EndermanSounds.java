package com.hicupalot;

import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class EndermanSounds implements Listener {
    @EventHandler
    public void Genderman(PlayerEvent e ){
        if (e.getPlayer().hasPermission("becomeranboo.ender")){
        if (e.getPlayer().getHeight()==101 || e.getPlayer().getHeight()==45){
        e.getPlayer().playSound(e.getPlayer().getLocation(),Sound.ENTITY_ENDERMAN_AMBIENT,10,29);

        }
        }
    }
}
