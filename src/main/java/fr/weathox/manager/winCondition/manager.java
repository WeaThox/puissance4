package fr.weathox.manager.winCondition;

import fr.weathox.manager.register;
import fr.weathox.manager.start;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.material.Wool;

public class manager {


    public static Boolean equalityStatut = false;

    public Boolean hasPlayerWin(Location blockLocation) {

        if (horizontale(blockLocation)) {
            Bukkit.broadcastMessage("DEBUG 0");
            return true;
        } else if (verticale(blockLocation)) {
            Bukkit.broadcastMessage("DEBUG 1");
            return true;
        } else if (diagonale(blockLocation)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean horizontale(Location blockLocation) {

        int counter = 0;

        for (int i = 1; i < 4; i++) {
            blockLocation.setX(blockLocation.getX() + i);
            Bukkit.broadcastMessage(start.actualPlayer + blockLocation.getBlock().getType());
            if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                counter += 1;
            }else if(start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL){
                counter+=1;
            }
        }
        if (counter == 3) {
            return true;
        }
        counter = 0;
        for (int i = -1; i > -3; i--) {
            blockLocation.setX(blockLocation.getX() + i);
            if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                counter += 1;
            }else if(start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL){
                counter+=1;
            }

        }
        return counter == 3;

    }



    public Boolean verticale(Location blockLocation){
        int counter = 0;

        for(int i = 1; i < 4; i ++){
            blockLocation.setX(blockLocation.getY() + i);
            if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                counter += 1;
            }else if(start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL){
                counter+=1;
            }
        }
        if(counter == 3){
            return true;
        }
        counter = 0;
        for(int i = -1; i > -3; i --){
            blockLocation.setX(blockLocation.getY() + i);
            if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                counter += 1;
            }else if(start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL){
                counter+=1;
            }
        }
        return counter == 3;
    }

    public Boolean diagonale(Location blockLocation){
        return false;
    }

    public Boolean isEquality(){
        return false;
    }
}
