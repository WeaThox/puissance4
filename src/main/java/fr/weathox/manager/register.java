package fr.weathox.manager;

import fr.weathox.Puissance;
import org.bukkit.entity.Player;

public class register {

    public static Boolean player1Statut = false;
    public static Boolean player2Statut = false;

    public static String player1name;
    public static String player2name;
    // Cette méthode envoie un message au joueur indiquant de saisir le pseudo du premier joueur
// et met à jour la variable player1Statut pour indiquer que le premier joueur est en train d'être enregistré
    public void registerFirstPlayer(Player player){

        player.sendMessage(Puissance.prefix + "§fRenseignez le pseudo du §cpremier §fjoueur.");
        player1Statut = true;

    }

    // Cette méthode envoie un message au joueur indiquant de saisir le pseudo du second joueur
// et met à jour la variable player2Statut pour indiquer que le second joueur est en train d'être enregistré
    public void registerSecondPlayer(Player player){

        player.sendMessage(Puissance.prefix + "§fRenseignez le pseudo du §6second §fjoueur.");
        player2Statut = true;
    }

}
