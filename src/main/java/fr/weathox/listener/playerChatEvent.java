package fr.weathox.listener;

import fr.weathox.Puissance;
import fr.weathox.manager.register;
import fr.weathox.manager.start;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class playerChatEvent implements Listener {
    private Puissance plugin;
    public playerChatEvent(Puissance plugin) { this.plugin = plugin;}

    public static String player1Name;
    public static String player2Name;

    @EventHandler
    public void onPlayerSendMessage(PlayerChatEvent event){

        if(register.player1Statut){
            player1Name = event.getMessage();
            event.getPlayer().sendMessage(Puissance.prefix + "Le joueur §b1 §fest §b"+ player1Name);
            register.player1Statut = false;
            new register().registerSecondPlayer(event.getPlayer());
            return;

        }else if(register.player2Statut){
            player2Name = event.getMessage();
            event.getPlayer().sendMessage(Puissance.prefix + "Le joueur §b2 §fest §b" + player2Name);
            register.player2Statut = false;
            new start().startGame(event.getPlayer(), player1Name, player2Name);
            return;
        }
        if(start.statutGame){
            new verifyColonne().isColonneFree(Integer.parseInt(event.getMessage()));
        }

    }
}
