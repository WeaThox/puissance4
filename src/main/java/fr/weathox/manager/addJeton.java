package fr.weathox.manager;

import fr.weathox.manager.winCondition.manager;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

import java.util.Objects;

import static fr.weathox.manager.start.actualPlayer;

public class addJeton {

    public static Location blockPoseLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);
    public static void poseBlock(String player, int colonne, Player Player) {
        // Définir la position du bloc à placer
        blockPoseLocation.setX(colonne);

        // Pour chaque ligne de la colonne
        for(int i = 105; i <112; i++) {
            blockPoseLocation.setY(i);
            // Si la case est vide
            if(blockPoseLocation.getBlock().getType() == Material.AIR) {
                // Si c'est le joueur 1 qui pose le bloc
                if(Objects.equals(player, register.player1name)) {
                    // Placer un bloc rouge
                    blockPoseLocation.getBlock().setType(Material.STAINED_CLAY);
                    blockPoseLocation.getBlock().setData(DyeColor.RED.getData());
                } else {
                    // Sinon, c'est le joueur 2 qui pose le bloc, donc on place un bloc jaune
                    Wool wool = new Wool(DyeColor.YELLOW);
                    blockPoseLocation.getBlock().setType(wool.getItemType());
                    blockPoseLocation.getBlock().setData(DyeColor.YELLOW.getData());
                }
                // Arrêter la boucle
                i = 112;
            }
        }

        // Si un joueur a gagné
        if(new manager().hasPlayerWin(blockPoseLocation)) {
            // Fin de la partie
            new end().endParty(actualPlayer, Player);
            return;
        }
        // Si la partie est terminée en égalité
        else if(new manager().isEquality(blockPoseLocation)) {
            manager.equalityStatut = true;
            new end().endParty(player, Player);
        }

        // Passer au joueur suivant
        if(Objects.equals(actualPlayer, register.player1name)) {
            actualPlayer = register.player2name;
        } else {
            actualPlayer = register.player1name;
        }

        // Démarrer le jeu
        new start().startGame(Player, register.player1name, register.player2name);
    }


}
