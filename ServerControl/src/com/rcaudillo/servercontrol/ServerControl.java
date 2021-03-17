package com.rcaudillo.servercontrol;

import com.rcaudillo.servercontrol.commands.server_maintenance.FinishServerMaintenance;
import com.rcaudillo.servercontrol.commands.server_maintenance.ServerMaintenance;
import com.rcaudillo.servercontrol.commands.server_restart.FinishServerRestart;
import com.rcaudillo.servercontrol.commands.ServerInfo;
import com.rcaudillo.servercontrol.commands.server_restart.ServerRestart;
import com.rcaudillo.servercontrol.events.PlayerJoin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerControl extends JavaPlugin {

    private static ServerControl instance;

    @Override
    public void onEnable() {
        //Register Events
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        //Register Commands
        getCommand("server-info").setExecutor(new ServerInfo());
        getCommand("server-restart").setExecutor(new ServerRestart());
        getCommand("finish-server-restart").setExecutor(new FinishServerRestart());
        getCommand("server-maintenance").setExecutor(new ServerMaintenance());
        getCommand("finish-server-maintenance").setExecutor(new FinishServerMaintenance());


        //Start End
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ServerControl Is Enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "ServerControl Is Disabled");
    }


    public static ServerControl getInstance() {
        return instance;
    }
}
