package fr.weathox.manager;

import fr.weathox.Puissance;
import fr.weathox.manager.winCondition.manager;
import fr.weathox.utils.NMSUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class end {

    Location initialLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);

    public void endParty(String player, Player Player){
        // On boucle sur toutes les colonnes du jeu
        for(int i = 1; i <8; i++){
            // On positionne la Location sur la colonne courante
            initialLocation.setX(i);
            // Pour chaque colonne, on boucle sur toutes les lignes
            for(int j = 106; j < 112; j++){
                // On positionne la Location sur la ligne courante
                initialLocation.setY(j);
                // On vide la case en cours
                initialLocation.getBlock().setType(Material.AIR);
            }
        }

        // Si la partie s'est terminée sur une égalité
        if(manager.equalityStatut){
            // On affiche un titre indiquant qu'il y a eu égalité
            NMSUtils.sendTitle(Player, "§bEgalité !", "§fLa partie est terminée.", 1, 3, 1);
            // On met à jour le statut d'égalité
            manager.equalityStatut = false;
            // On met à jour le statut de la partie
            start.statutGame = false;
        }else {
            // Sinon, on affiche un titre indiquant qui a gagné
            NMSUtils.sendTitle(Player, "§aGagné !", "§b" + player + "§f a gagné la partie", 1, 3, 1);
        }
        // On envoie un message au joueur pour lui indiquer que la partie a recommencer automatiquement !
        Player.sendMessage(Puissance.prefix + "§fLa partie vient de §brecommencer§f. C'est à §6" + start.actualPlayer + "§f de jouer !");
    }


}
