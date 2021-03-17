package com.rcaudillo.servercontrol.commands.server_maintenance;

import com.rcaudillo.servercontrol.commands.server_restart.ServerRestart;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FinishServerMaintenance implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        //FinishServerMaintenance
        if(cmd.getName().equalsIgnoreCase("finish-server-maintenance")){
            ServerMaintenance.isServerUnderMaintenance = false;
            player.getServer().broadcastMessage(ChatColor.GREEN + "Maintenance finished, players can now join!");
        }

        return true;
    }
}
