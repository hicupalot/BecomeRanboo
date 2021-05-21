package com.hicupalot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.UUID;

public class RanbooChat implements Listener {
    private HashMap<String, Long> ChatMessage = new HashMap<String, Long>();

    @EventHandler
    public void Chat(AsyncPlayerChatEvent e) {
        if (e.getPlayer().hasPermission("becomeranboo.chat")) {
            ChatMessage.get(e.getMessage());
            String chat = ChatMessage.toString();
            e.setCancelled(true);
            Bukkit.broadcast("<Ranboo> " + chat, "becomeranboo.chatrecieve");
            ChatMessage.clear();

        }
    }
}
