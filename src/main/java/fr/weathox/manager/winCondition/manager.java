package fr.weathox.manager.winCondition;

import fr.weathox.manager.register;
import fr.weathox.manager.start;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class manager {


    public static Boolean equalityStatut = false;

    public Boolean hasPlayerWin(Location blockLocation) {

        // Vérifie si la condition de victoire est remplie horizontalement
        if (horizontale(blockLocation)) {
            return true;
        }
        // Vérifie si la condition de victoire est remplie verticalement
        else if (verticale(blockLocation)) {
            return true;
        }
        // Vérifie si la condition de victoire est remplie diagonalement
        else return diagonale(blockLocation);
    }

    public Boolean horizontale(Location blockLocation) {
        // Compteur pour compter le nombre de cases de la même couleur
        int counter = 0;

        // Pour chaque case de la ligne
        for (int i = 1; i < 4; i +=1) {
            // On se déplace à gauche
            blockLocation.setX(blockLocation.getX() - i);

            // Si on est pas à la bordure gauche
            if(blockLocation.getX() != 0) {
                // Si la case est de la même couleur que le joueur actuel
                if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                    counter += 1;
                } else if (start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL) {
                    counter += 1;
                }
            }
            // On se déplace à droite pour ne pas influencer la prochaine itération
            blockLocation.setX(blockLocation.getX() + i);
        }
        // Si toutes les cases ont été de la même couleur
        if(counter== 3){
            return true;
        }

        // Réinitialisation du compteur
        counter = 0;

        // Pour chaque case de la ligne
        for (int i = -1; i > -4; i -=1) {
            // On se déplace à droite
            blockLocation.setX(blockLocation.getX() + i);

            // Si on est pas à la bordure droite
            if(blockLocation.getX() !=8) {
                // Si la case est de la même couleur que le joueur actuel
                if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                    counter += 1;
                } else if (start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL) {
                    counter += 1;
                }
                // On se déplace à gauche pour ne pas influencer la prochaine itération
                blockLocation.setX(blockLocation.getX() - i);
            }

        }
        // Si toutes les cases ont été de la même couleur
        return counter == 3;
    }




    public Boolean verticale(Location blockLocation){
        int counter = 0;

        for(int i = -1; i > -4; i -=1){
            // Déplace le blockLocation à un emplacement différent
            blockLocation.setY(blockLocation.getY() + i);

            // Si la nouvelle position du blockLocation n'est pas sur la limite supérieure
            if(blockLocation.getY() !=105) {
                // Si le joueur courant est le premier joueur et que le type du bloc correspond au type attendu
                if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                    // Incrémente le compteur
                    counter += 1;
                    // Sinon, si le joueur courant est le deuxième joueur et que le type du bloc correspond au type attendu
                } else if (start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL) {
                    // Incrémente le compteur
                    counter += 1;
                }
            }
            // Retourne le blockLocation à sa position initiale
            blockLocation.setY(blockLocation.getY() - i);
        }
        // Si le compteur atteint 3, renvoie vrai
        return counter == 3;
    }



    public Boolean diagonale(Location blockLocation){
        // Initialiser le compteur à 0
        int counter = 0;

        // Pour chaque i dans la plage [-1, -4[, décrémenter i
        for(int i = -1; i > -4; i -=1){
            // Ajouter i à la position en x et y de blockLocation
            blockLocation.setX(blockLocation.getX() + i);
            blockLocation.setY(blockLocation.getY() + i);

            // Si la position en x ou y de blockLocation n'est pas 0 ou 105, respectivement
            if(blockLocation.getX() !=0 && blockLocation.getY() !=105) {
                // Si le joueur actuel est player1 et que le type de block à la position de blockLocation est STAINED_CLAY
                if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                    // Incrémenter le compteur
                    counter += 1;
                }
                // Sinon, si le joueur actuel est player2 et que le type de block à la position de blockLocation est WOOL
                else if (start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL) {
                    // Incrémenter le compteur
                    counter += 1;
                }
            }

            // Soustraire i à la position en x et y de blockLocation
            blockLocation.setX(blockLocation.getX() - i);
            blockLocation.setY(blockLocation.getY() - i);
        }

        // Si le compteur est égal à 3, retourner vrai
        // Sinon, retourner faux
        return counter == 3;
    }

    public Boolean isEquality(Location blockPoseLocation) {
        // Vérifier si les 7 colonnes sont complètes
        boolean isFull = true;
        for (int i = 0; i < 7; i++) {
            blockPoseLocation.setX(i);
            // Si une colonne n'est pas complète
            if (blockPoseLocation.getBlock().getType() == Material.AIR) {
                isFull = false;
                break;
            }
        }

        // Si les 7 colonnes sont complètes
        if (isFull) {
            // Retourner vrai
            return true;
        } else {
            // Sinon, retourner faux
            return false;
        }
    }
}
