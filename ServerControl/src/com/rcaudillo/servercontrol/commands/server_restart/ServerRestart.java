package com.rcaudillo.servercontrol.commands.server_restart;

import com.rcaudillo.servercontrol.ServerControl;
import com.rcaudillo.servercontrol.util.PluginMath;
import com.rcaudillo.servercontrol.util.PluginMsg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class ServerRestart implements CommandExecutor {
    public static String serverRestartReason;
    public static boolean isServerRestarting = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        serverRestartReason = args[1];

        // ServerRestart
        if(cmd.getName().equalsIgnoreCase("server-restart")){
            if(args.length >= 2){
                for (int i = Integer.parseInt(args[0]); i > -1; i--) {
                    player.getServer().broadcastMessage(ChatColor.RED + "Server restart in "+ PluginMsg.displayIntMessage(i));
                    try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                    if(i == 0){
                        for (Player target : player.getServer().getOnlinePlayers()){
                            target.kickPlayer(ChatColor.RED + "The Server Is Restarting"+
                                    "\n\n"+ChatColor.WHITE+"Reason for restart: "+
                                    "\n"+ChatColor.GRAY+serverRestartReason);
                            isServerRestarting = true;
                        }
                    }
                }

            } else {
                player.sendMessage(ChatColor.RED + "Incorrect command format...");
                player.sendMessage(ChatColor.AQUA + "Use (/"+label+" <WaitSeconds> <RestartMessage>");
            }
        }

        return true;
    }
}
