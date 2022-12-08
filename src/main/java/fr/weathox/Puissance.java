package fr.weathox;

import fr.weathox.listener.playerChatEvent;
import fr.weathox.listener.playerJoinEvent;
import fr.weathox.listener.playerMoveEvent;
import fr.weathox.zone.creation;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Puissance extends JavaPlugin {

    public static String prefix = "§8§lPuissance§c 4 §8§l» ";

    @Override
    public void onEnable() {
        System.out.printf("Puissance 4 is enabled ! Happy tu see u :)");
        Bukkit.getServer().getPluginManager().registerEvents(new playerJoinEvent(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new playerChatEvent(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new playerMoveEvent(),this);
        new creation().mapCreation();

    }

    @Override
    public void onDisable() {
        System.out.println("Puisssance 4 is disabled ! See you soon :)");
    }
}
