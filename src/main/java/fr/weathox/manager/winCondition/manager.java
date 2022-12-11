package fr.weathox.manager.winCondition;

import fr.weathox.manager.register;
import fr.weathox.manager.start;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class manager {


    public static Boolean equalityStatut = false;

    public Boolean hasPlayerWin(Location blockLocation) {

        // Vérifie si la condition de victoire est remplie horizontalement
        if (verticale(blockLocation)) {
            Bukkit.broadcastMessage("VERTICALE");
            return true;
        }
        // Vérifie si la condition de victoire est remplie verticalement
        else if (horizontale(blockLocation)) {
            Bukkit.broadcastMessage("HORIZONTALE");
            return true;
        }else return(diagonale(blockLocation));
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

        int counter = 0;
        Location location = new Location(Bukkit.getWorld("world"), blockLocation.getX(), blockLocation.getY(), blockLocation.getZ());

        for(int i = 1; i < 4; i++){
            location.setX(location.getX() - i);
            if(location.getBlock().getType() == blockLocation.getBlock().getType()){
                if(location.getX() != 0 && location.getX() != 8) {
                    counter += 1;
                }
            } else{
                location.setX(location.getX() + i);
                break;
            }
            location.setX(location.getX() + i);
        }
        boolean isOnlyRightQuatuor = counter == 0;
        for(int i =1; i<4; i++){
            location.setX(location.getX() + i);
            if(location.getBlock().getType() == blockLocation.getBlock().getType()){
                if(location.getX() != 0 && location.getX() != 8) {
                    counter += 1;
                }
            } else{
                location.setX(location.getX() - i);
                break;
            }
            location.setX(location.getX() - i);
        }
        if(isOnlyRightQuatuor){
            return counter >=3;
        }
        return counter >= 3;

    }

    ArrayList<Block> diagonaleList = new ArrayList<>();
    public Boolean diagonale(Location blockLocation){
        int counter = 0;
        Block block = blockLocation.getBlock();
        diagonaleList.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST));
        diagonaleList.add(diagonaleList.get(0).getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST));
        diagonaleList.add(diagonaleList.get(1).getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST));
        diagonaleList.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
        diagonaleList.add(diagonaleList.get(3).getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
        diagonaleList.add(diagonaleList.get(4).getRelative(BlockFace.UP).getRelative(BlockFace.EAST));

        for(int i =0; i < diagonaleList.size(); i+=1){
            Block blocks = diagonaleList.get(i);
            if(blocks.getLocation().getX() != 0 && blocks.getLocation().getX() != 8){
                if(blocks.getLocation().getY() !=105 && blocks.getLocation().getY() != 112){
                    if(blocks.getType() == block.getType()){
                        counter += 1;
                    }
                }
            }
        }
        for(int i =0; i<6; i++){
            diagonaleList.remove(0);
        }
        if(counter >=3){
            return true;
        }
        counter = 0;
        diagonaleList.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST));
        diagonaleList.add(diagonaleList.get(0).getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST));
        diagonaleList.add(diagonaleList.get(1).getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST));
        diagonaleList.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
        diagonaleList.add(diagonaleList.get(3).getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
        diagonaleList.add(diagonaleList.get(4).getRelative(BlockFace.UP).getRelative(BlockFace.WEST));

        for(int i =0; i < diagonaleList.size(); i++){
            Block blocks = diagonaleList.get(i);
            if(blocks.getLocation().getX() != 0 && blocks.getLocation().getX() != 8){
                if(blocks.getLocation().getY() !=105 && blocks.getLocation().getY() != 112){
                    if(blocks.getType() == block.getType()){
                        counter += 1;
                    }
                }
            }
        }
        for(int i =0; i<6; i++){
            diagonaleList.remove(0);
        }
        return counter >=3;

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
