package com.rcaudillo.servercontrol.commands;

import com.rcaudillo.servercontrol.ServerControl;
import com.rcaudillo.servercontrol.util.PluginMath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerRestart implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        // ServerRestart
        if(cmd.getName().equalsIgnoreCase("server-restart")){
            if(args.length >= 1){
                int restartSecondsLeft = Integer.parseInt(args[0]);
                int originalSeconds = Integer.parseInt(args[0]);

                for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                    int tick = PluginMath.convertSecToTick(restartSecondsLeft);
                    int restartSecondsToDisplay = restartSecondsLeft;
                    player.getServer().getScheduler().runTaskLater (Bukkit.getPluginManager ().getPlugin("ServerControl"), () -> {
                        player.getServer().broadcastMessage(ChatColor.RED+"Server restart in " + (originalSeconds+1-restartSecondsToDisplay));
                    }, tick);
                    restartSecondsLeft--;
                }
            } else {
                player.sendMessage(ChatColor.RED + "/server-restart  <waitAmount> <restartMessage>");
            }
        }

        return true;
    }
}
