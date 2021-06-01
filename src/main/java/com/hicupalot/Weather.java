package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Weather implements Listener {
    @EventHandler
    public void Rain(WeatherChangeEvent e){
    if (e.toWeatherState()){
        Bukkit.broadcast(ChatColor.YELLOW + "Its raining! You better bring a helmet!", "becomeranboo.ranboofacts");
    }
    }
}
