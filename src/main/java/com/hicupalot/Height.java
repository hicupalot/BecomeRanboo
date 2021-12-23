package com.hicupalot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Height implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (sender.hasPermission("becomeranboo.ranboofacts")){
                sender.sendMessage(ChatColor.RED+ "You are 8\" 5'" + "or 6\" 7' depending on the day");
            }
            else{
                sender.sendMessage(ChatColor.RED+ "You do not have permission to use this command");
                return false;
            }
        }
    return false;
    }
}
