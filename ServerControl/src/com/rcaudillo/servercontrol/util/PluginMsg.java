package com.rcaudillo.servercontrol.util;

import org.bukkit.ChatColor;

public class PluginMsg {

    public static String displayIntMessage(int second){
        if(second == 1 || second == -1){
            return second+" second.";
        } else {
            return second+" seconds.";
        }
    }
    public static String displayTPS(double TPS){
        if (TPS <= 17){
            return (ChatColor.RED + String.valueOf(TPS));
        } else {
            return (ChatColor.GREEN + String.valueOf(TPS));
        }
    }
}
