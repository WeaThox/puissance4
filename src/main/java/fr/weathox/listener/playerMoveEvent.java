package fr.weathox.listener;

import fr.weathox.Puissance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class playerMoveEvent implements Listener {
    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event){
        Player player = event.getPlayer();

        //on vérifie que la localisation du joueur moins la localisation de spawn du joueur reste dans un encadrement [-2;2] en X puis Z et enfin Y
        if(player.getLocation().getX() - playerJoinEvent.spawnPlayer.getX() > 2 || player.getLocation().getX() - playerJoinEvent.spawnPlayer.getX() < -2){
            player.teleport(playerJoinEvent.spawnPlayer);
        }else if(player.getLocation().getZ() - playerJoinEvent.spawnPlayer.getZ() > 2 || player.getLocation().getZ() - playerJoinEvent.spawnPlayer.getZ() < -2){
            player.teleport(playerJoinEvent.spawnPlayer);
        }else if(player.getLocation().getY() - playerJoinEvent.spawnPlayer.getY() > 2 || player.getLocation().getY() - playerJoinEvent.spawnPlayer.getY() < -2) {
            player.teleport(playerJoinEvent.spawnPlayer);
        }
    }
}
