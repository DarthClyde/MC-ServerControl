package com.rcaudillo.servercontrol.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        //Send Private Welcome Message
        player.sendMessage(ChatColor.AQUA + "Welcome "+player.getName()+ ", enjoy your stay.");
    }
}
