package com.rcaudillo.servercontrol.events;

import com.rcaudillo.servercontrol.commands.server_maintenance.ServerMaintenance;
import com.rcaudillo.servercontrol.commands.server_restart.ServerRestart;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        //Check if server is restarting
        if(ServerRestart.isServerRestarting){
            if(!player.isOp()){
                player.kickPlayer(ChatColor.RED + "The Server Is Restarting"+
                        "\n\n"+ChatColor.WHITE+"Reason for restart: "+
                        "\n"+ChatColor.GRAY+ServerRestart.serverRestartReason);
            }
        }
        else if (ServerMaintenance.isServerUnderMaintenance){
            if(!player.isOp()){
                player.kickPlayer(ChatColor.RED + "The Server Is Undergoing Maintenance"+
                        "\n\n"+ChatColor.GRAY+"For more information contact an admin");
            }
        }
        //Send Private Welcome Message
        player.sendMessage(ChatColor.AQUA + "Welcome "+player.getName()+ ", enjoy your stay.");
    }
}
