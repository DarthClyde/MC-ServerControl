package com.rcaudillo.servercontrol;

import com.rcaudillo.servercontrol.commands.ServerInfo;
import com.rcaudillo.servercontrol.events.PlayerJoin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerControl extends JavaPlugin {

    @Override
    public void onEnable() {
        //Register Events
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        //Register Commands
        getCommand("serverinfo").setExecutor(new ServerInfo());


        //Start End
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ServerControl Is Enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "ServerControl Is Disabled");
    }
}
