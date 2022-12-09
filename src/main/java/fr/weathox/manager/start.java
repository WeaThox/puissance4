package fr.weathox.manager;

import fr.weathox.Puissance;
import fr.weathox.listener.playerChatEvent;
import fr.weathox.listener.playerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.Objects;

public class start {

    public static String actualPlayer;
    public static int numberPlayerTurn = 1;
    public static Boolean statutGame = false;

    public void startGame(Player player, String player1, String player2){

        if(actualPlayer == null){
            playerChatEvent.bossBarRegisterPlayer2.removePlayer(player);
            actualPlayer = player1;
            playerChatEvent.bossbarPlayer1.addPlayer(player);

        }

        player.sendMessage(Puissance.prefix + "§fC'est au joueur §b" + actualPlayer + "§f de jouer.");

    }

}
