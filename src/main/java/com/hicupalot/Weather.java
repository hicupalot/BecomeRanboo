package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.concurrent.TimeUnit;

public class Weather  implements Listener {
    @EventHandler()
    public void Rain(WeatherChangeEvent e) throws InterruptedException {
        while (e.toWeatherState()) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                assert (players.getInventory().getHelmet() != null);
                if (players.hasPermission("becomeranboo.ender") && !players.getInventory().getHelmet().getType().isItem()) {
                    if (players.getLocation().getBlockY() > players.getWorld().getHighestBlockYAt(players.getLocation()))
                        players.damage(0.5);
                    TimeUnit.SECONDS.sleep(5);
                }
            }
        }
    }
}