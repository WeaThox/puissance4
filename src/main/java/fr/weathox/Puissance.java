package fr.weathox;

import fr.weathox.listener.playerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Puissance extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.printf("Puissance 4 is enabled ! Happy tu see u :)");
        Bukkit.getServer().getPluginManager().registerEvents(new playerJoinEvent(this),this);

    }

    @Override
    public void onDisable() {
        System.out.println("Puisssance 4 is disabled ! See you soon :)");
    }
}
