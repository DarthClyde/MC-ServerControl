package com.rcaudillo.servercontrol.util;

public class PluginMath {

    public static int convertSecToTick(String sec){
        return Integer.parseInt(sec) * 20;
    }
    public static int convertSecToTick(int sec){
        return sec * 20;
    }

    public static int convertTickToSec(String tick){
        return Integer.parseInt(tick) / 20;
    }
    public static int convertTickToSec(int tick){
        return tick / 20;
    }
}
