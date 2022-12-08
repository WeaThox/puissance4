package fr.weathox.manager;

import fr.weathox.Puissance;
import org.bukkit.entity.Player;

public class register {

    public static Boolean player1Statut = false;
    public static Boolean player2Statut = false;

    public void registerFirstPlayer(Player player){

        player.sendMessage(Puissance.prefix + "Renseignez le pseudo du premier joueur");
        player1Statut = true;

    }

}
