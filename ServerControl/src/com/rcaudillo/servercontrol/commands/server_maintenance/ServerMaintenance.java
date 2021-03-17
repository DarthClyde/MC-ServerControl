package com.rcaudillo.servercontrol.commands.server_maintenance;

import com.rcaudillo.servercontrol.util.PluginMsg;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class ServerMaintenance implements CommandExecutor {
    public static boolean isServerUnderMaintenance = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        //ServerMaintenance
        if(cmd.getName().equalsIgnoreCase("server-maintenance")){
            if(args.length >= 1){
                for (int i = Integer.parseInt(args[0]); i > -1; i--) {
                    player.getServer().broadcastMessage(ChatColor.RED + "Disconnecting for maintenance in "+ PluginMsg.displayIntMessage(i));
                    try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                    if(i == 0){
                        for (Player target : player.getServer().getOnlinePlayers()){
                            target.kickPlayer(ChatColor.RED + "The Server Is Undergoing Maintenance"+
                                    "\n\n"+ChatColor.GRAY+"For more information contact an admin");
                            isServerUnderMaintenance = true;
                        }
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "Incorrect command format...");
                player.sendMessage(ChatColor.AQUA + "Use (/"+label+" <WaitAmount>");
            }
        }

        return true;
    }
}
