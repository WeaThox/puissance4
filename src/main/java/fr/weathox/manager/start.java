package fr.weathox.manager;

import fr.weathox.Puissance;
import org.bukkit.entity.Player;

import java.util.Objects;

public class start {

    public static String actualPlayer;
    public static int numberPlayerTurn = 1;
    public static Boolean statutGame = false;


    public void startGame(Player player, String player1, String player2){

        if(actualPlayer == null){
            actualPlayer = player1;
        }

        player.sendMessage(Puissance.prefix + "§fC'est au joueur §b" + actualPlayer + "§f de jouer. [1] [2] [3] [4] [5] [6] [7]");

    }

}
