package fr.weathox.listener;

import fr.weathox.Puissance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class playerMoveEvent implements Listener {
    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event){
        event.setCancelled(true);
    }
}
