package fr.weathox.manager;

import fr.weathox.Puissance;
import org.bukkit.entity.Player;

public class register {

    public static Boolean player1Statut = false;
    public static Boolean player2Statut = false;

    public void registerFirstPlayer(Player player){

        player.sendMessage(Puissance.prefix + "§fRenseignez le pseudo du §cpremier §fjoueur.");
        player1Statut = true;

    }

    public void registerSecondPlayer(Player player){

        player.sendMessage(Puissance.prefix + "§fRenseignez le pseudo du §6second §fjoueur.");
        player2Statut = true;
    }

}