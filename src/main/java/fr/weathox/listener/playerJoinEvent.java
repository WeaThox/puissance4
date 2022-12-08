package fr.weathox.listener;

import fr.weathox.Puissance;
import fr.weathox.manager.register;
import fr.weathox.utils.NMSUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoinEvent implements Listener {

    private Puissance plugin;
    public playerJoinEvent(Puissance plugin) { this.plugin = plugin;}
    public static Location spawnPlayer = new Location(Bukkit.getWorld("world"), 4.0, 106,  9, (float)178.8,  (float)1.9);
    Location initialLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(null);

        for(int i = 1; i <8; i++){
            initialLocation.setX(i);
            for(int j = 106; j < 112; j++){
                initialLocation.setY(j);
                initialLocation.getBlock().setType(Material.AIR);
            }

        }

        spawnPlayer.setY(spawnPlayer.getY() + 1);
        Player player = event.getPlayer();
        player.teleport(spawnPlayer);
        player.setGameMode(GameMode.CREATIVE);
        NMSUtils.sendTitle(player, "§8§lPuissance §c4", "§fDe §6§lHugo §fet §6§lTitouan", 1, 3, 1);
        new register().registerFirstPlayer(player);
    }
}
