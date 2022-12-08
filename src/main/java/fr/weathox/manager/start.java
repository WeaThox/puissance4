package fr.weathox.manager;

import fr.weathox.Puissance;
import org.bukkit.entity.Player;

public class start {

    public static String actualPlayer;
    public static Boolean statutGame;

    public void startGame(Player player, String player1, String player2){

        if(actualPlayer == null){
            actualPlayer = player1;
        }

        player.sendMessage(Puissance.prefix + "C'est au joueur §b" + actualPlayer + "§f de jouer. Merci de préciser dans quelle colonne vous souhaitez jouer.");

    }

}
