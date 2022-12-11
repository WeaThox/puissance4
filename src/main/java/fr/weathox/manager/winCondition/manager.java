package fr.weathox.manager.winCondition;

import fr.weathox.manager.register;
import fr.weathox.manager.start;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.sql.SQLOutput;

public class manager {


    public static Boolean equalityStatut = false;

    public Boolean hasPlayerWin(Location blockLocation) {

        // Vérifie si la condition de victoire est remplie horizontalement
        if (verticale(blockLocation)) {
            return true;
        }
        // Vérifie si la condition de victoire est remplie verticalement
        else if (horizontale(blockLocation)) {
            return true;
        }
        // Vérifie si la condition de victoire est remplie diagonalement
        else if(diagonaleLeft(blockLocation)){
            return true;
        }else return(diagonaleRight(blockLocation));
    }

    public Boolean verticale(Location blockLocation){
        int counter = 0;

        for(int i = -1; i > -4; i -=1){
            // Déplace le blockLocation à un emplacement différent
            blockLocation.setY(blockLocation.getY() + i);

            // Si la nouvelle position du blockLocation n'est pas sur la limite inférieure
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

    public Boolean horizontale(Location blockLocation) {
        // Compteur pour compter le nombre de cases de la même couleur
        int counter = 0;
        Location location = blockLocation;
        // Pour chaque case de la ligne
        for (int i = 1; i < 4; i +=1) {
            // On se déplace à gauche
            location.setX(blockLocation.getX() - i);

            // Si on est pas à la bordure gauche et droite
            if(location.getX() !=8 && location.getX() != 0) {
                // Si la case est de la même couleur que le joueur actuel
                if (start.actualPlayer.equals(register.player1name) && location.getBlock().getType() == Material.STAINED_CLAY) {
                    counter += 1;
                } else if (start.actualPlayer.equals(register.player2name) && location.getBlock().getType() == Material.WOOL) {
                    counter += 1;
                }
            }
            // On se déplace à droite pour ne pas influencer la prochaine itération
            location.setX(location.getX() + i);
        }
        // Si toutes les cases ont été de la même couleur
        System.out.println(counter);
        if(counter== 3){
            return true;
        }

        // Réinitialisation du compteur
        counter = 0;

        // Pour chaque case de la ligne
        for (int i = -1; i > -4; i -=1) {
            // On se déplace à droite
            location.setX(location.getX() + i);

            // Si on est pas à la bordure droite ni à gauche
            if(location.getX() !=8 && location.getX() != 0) {
                // Si la case est de la même couleur que le joueur actuel
                if (start.actualPlayer.equals(register.player1name) && location.getBlock().getType() == Material.STAINED_CLAY) {
                    counter += 1;
                } else if (start.actualPlayer.equals(register.player2name) && location.getBlock().getType() == Material.WOOL) {
                    counter += 1;
                }
                // On se déplace à gauche pour ne pas influencer la prochaine itération
                location.setX(location.getX() - i);
            }

        }
        // Si toutes les cases ont été de la même couleur
        System.out.println(counter);
        return counter == 3;
    }


    public Boolean diagonaleLeft(Location blockLocation){

        Block block = blockLocation.getBlock();
        Material type = block.getType();
        //on récupère les 3 blocks dans la diagonale inférieure droite
        Block block1 = block.getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST);
        Block block2 = block1.getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST);
        Block block3 = block2.getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST);
        //on vérifie qu'ils ne fassent pas partis des bordures.
        if(block1.getLocation().getY() == 105 || block2.getLocation().getY() == 105 || block3.getLocation().getY() == 105){
            return false;
        }
        //on renvoie si la diagonale est complète ou non
        return (block1.getType() == type && block2.getType() == type && block3.getType() == type);
    }

    public Boolean diagonaleRight(Location blockLocation){
        Block block = blockLocation.getBlock();
        Material type = block.getType();
        //on récupère les 3 blocks dans la diagonale inférieure droite
        Block block1 = block.getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST);
        Block block2 = block1.getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST);
        Block block3 = block2.getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST);
        //on vérifie qu'ils ne fassent pas partis des bordures.
        if(block1.getLocation().getY() == 105 || block2.getLocation().getY() == 105 || block3.getLocation().getY() == 105){
            return false;
        }
        //on renvoie si la diagonale est complète ou non
        return (block1.getType() == type && block2.getType() == type && block3.getType() == type);
    }

    public Boolean isEquality(Location blockPoseLocation) {
        // Vérifier si les 7 colonnes sont complètes
        boolean isFull = true;
        for (int i = 0; i < 7; i++) {
            blockPoseLocation.setY(111);
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
