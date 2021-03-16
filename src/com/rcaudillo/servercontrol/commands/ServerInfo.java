package com.rcaudillo.servercontrol.commands;

import com.rcaudillo.servercontrol.util.lag;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerInfo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Only in-game players can run this command");
            return true;
        }
        Player player = (Player) sender;

        // ServerInfo
        if(cmd.getName().equalsIgnoreCase("serverinfo")){
            player.sendMessage("Server Version -> "+ player.getServer().getBukkitVersion());
            player.sendMessage("Server TPS -> "+ lag.getTPS());
            player.sendMessage("Online Players -> "+ sender.getServer().getOnlinePlayers());
        }

        return true;
    }
}
