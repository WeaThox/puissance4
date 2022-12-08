package fr.weathox.listener;

import fr.weathox.Puissance;
import fr.weathox.manager.register;
import fr.weathox.utils.NMSUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoinEvent implements Listener {

    private Puissance plugin;
    public playerJoinEvent(Puissance plugin) { this.plugin = plugin;}
    Location spawnPlayer = new Location(Bukkit.getWorld("world"), -15, 100,  0);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        player.teleport(spawnPlayer);
        player.setGameMode(GameMode.ADVENTURE);
        NMSUtils.sendTitle(player, "§8§lPuissance §c4", "§fDe §6§lHugo §fet §6§lTitouan", 1, 3, 1);
        new register().registerFirstPlayer(player);
    }
}
