package com.rcaudillo.servercontrol.commands.server_restart;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FinishServerRestart implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        //FinishServerRestart
        if(cmd.getName().equalsIgnoreCase("finish-server-restart")){
            ServerRestart.isServerRestarting = false;
            player.getServer().broadcastMessage(ChatColor.GREEN + "Restart finished, players can now join!");
        }

        return true;
    }
}
