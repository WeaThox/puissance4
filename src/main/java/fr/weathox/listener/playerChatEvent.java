package fr.weathox.listener;

import fr.weathox.Puissance;
import fr.weathox.manager.addJeton;
import fr.weathox.manager.register;
import fr.weathox.manager.start;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class playerChatEvent implements Listener {
    private Puissance plugin;
    public playerChatEvent(Puissance plugin) { this.plugin = plugin;}

    public static String player1Name;
    public static String player2Name;

    public static BossBar bossbarPlayer1;
    public static BossBar bossbarPlayer2;
    public static BossBar bossBarRegisterPlayer2 = Bukkit.createBossBar("Le premier joueur est §b" + register.player1name + " §f rentre le pseudo du second joueur !", BarColor.RED, BarStyle.SEGMENTED_10, BarFlag.DARKEN_SKY, BarFlag.CREATE_FOG);

    @EventHandler
    public void onPlayerSendMessage(PlayerChatEvent event){

        // Si le joueur 1 envoie un message
        if(register.player1Statut){
            event.setCancelled(true);
            player1Name = event.getMessage();
            // Affiche un message au joueur indiquant son nom
            event.getPlayer().sendMessage(Puissance.prefix + "§fLe joueur §b1 §fest §b"+ player1Name);
            // Met à jour le statut du joueur 1
            register.player1Statut = false;
            // Enregistre le nom du joueur 1
            register.player1name = event.getMessage();
            // Appelle la méthode pour enregistrer le joueur 2
            new register().registerSecondPlayer(event.getPlayer());
            // Change la BossBar du joueur
            bossBarRegisterPlayer2.setTitle("Le premier joueur est §b" + register.player1name + " §frentre le pseudo du second joueur !");
            playerJoinEvent.playerBossBar.removePlayer(event.getPlayer());
            bossBarRegisterPlayer2.addPlayer(event.getPlayer());
            return;

            // Si le joueur 2 envoie un message
        }else if(register.player2Statut){
            event.setCancelled(true);
            player2Name = event.getMessage();
            // Affiche un message au joueur indiquant son nom
            event.getPlayer().sendMessage(Puissance.prefix + "§fLe joueur §b2 §fest §b" + player2Name);
            // Met à jour le statut du joueur 2
            register.player2Statut = false;
            // Enregistre le nom du joueur 2
            register.player2name = event.getMessage();
            //créer les bossbar
            bossbarPlayer1 = Bukkit.createBossBar("C'est à §c" + register.player1name + " §fde jouer", BarColor.RED, BarStyle.SEGMENTED_10, BarFlag.DARKEN_SKY, BarFlag.CREATE_FOG);
            bossbarPlayer2 = Bukkit.createBossBar("C'est à §6" + register.player2name + " §fde jouer", BarColor.YELLOW, BarStyle.SEGMENTED_10, BarFlag.DARKEN_SKY, BarFlag.CREATE_FOG);;
            // Appelle la méthode pour démarrer la partie
            new start().startGame(event.getPlayer(), player1Name, player2Name);
            // Met à jour le statut de la partie
            start.statutGame = true;
            return;
        }

        // Si la partie est en cours
        if(start.statutGame){
            event.setCancelled(true);
            // Vérifie que le message envoyé par le joueur est un chiffre entre 1 et 7 inclus
            if(Integer.parseInt(event.getMessage()) > 7 || Integer.parseInt(event.getMessage()) < 1){
                // Si ce n'est pas le cas, envoie un message au joueur pour lui demander de renseigner un chiffre valide
                event.getPlayer().sendMessage(Puissance.prefix + "§fMerci de renseigner un chiffre entre 1 et 7 inclus.");
                return;
            }
            // Vérifie que la colonne choisie par le joueur est disponible
            if(!new verifyColonne().isColonneFree(Integer.parseInt(event.getMessage()))){
                // Si la colonne n'est pas disponible, envoie un message au joueur pour lui demander de choisir une autre colonne
                event.getPlayer().sendMessage(Puissance.prefix + "§fCette Colonne n'est pas disponible merci d'en choisir une autre.");
                return;
            }else{
                // Si la colonne est disponible, appeler la méthode poseBlock pour poser le block
                addJeton.poseBlock(start.actualPlayer, Integer.parseInt(event.getMessage()), event.getPlayer());
            }
        }

    }
}
