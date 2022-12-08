package fr.weathox.manager.winCondition;

import fr.weathox.manager.register;
import fr.weathox.manager.start;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class manager {


    public static Boolean equalityStatut = false;

    public Boolean hasPlayerWin(Location blockLocation) {

        if (horizontale(blockLocation)) {
            return true;
        } else if (verticale(blockLocation)) {
            return true;
        } else return diagonale(blockLocation);
    }

    public Boolean horizontale(Location blockLocation) {

        int counter = 0;
        for (int i = 1; i < 4; i +=1) {
            blockLocation.setX(blockLocation.getX() - i);
            if(blockLocation.getX() != 0) {
                if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                    counter += 1;
                } else if (start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL) {
                    counter += 1;
                }
            }
            blockLocation.setX(blockLocation.getX() + i);

        }
        if(counter== 3){
            return true;
        }

        counter = 0;
        for (int i = -1; i > -4; i -=1) {
            blockLocation.setX(blockLocation.getX() + i);
            if(blockLocation.getX() !=8) {
                if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                    counter += 1;
                } else if (start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL) {
                    counter += 1;
                }
                blockLocation.setX(blockLocation.getX() - i);
            }

        }
        return counter == 3;

    }



    public Boolean verticale(Location blockLocation){
        int counter = 0;

        for(int i = -1; i > -4; i -=1){
            blockLocation.setY(blockLocation.getY() + i);
            Bukkit.broadcastMessage(i + "~~" + blockLocation.getY() + "~~" +blockLocation.getBlock().getType() + start.actualPlayer);
            if(blockLocation.getY() !=105) {
                if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                    counter += 1;
                } else if (start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL) {
                    counter += 1;
                }
            }
            blockLocation.setY(blockLocation.getY() - i);
        }
        return counter == 3;
    }

        public Boolean diagonale(Location blockLocation){
            int counter = 0;
            for(int i = -1; i > -4; i -=1){
                blockLocation.setX(blockLocation.getX() + i);
                blockLocation.setY(blockLocation.getY() + i);
                if(blockLocation.getX() !=0 && blockLocation.getY() !=105) {
                    if (start.actualPlayer.equals(register.player1name) && blockLocation.getBlock().getType() == Material.STAINED_CLAY) {
                        counter += 1;
                    } else if (start.actualPlayer.equals(register.player2name) && blockLocation.getBlock().getType() == Material.WOOL) {
                        counter += 1;
                    }
                }
                blockLocation.setX(blockLocation.getX() - i);
                blockLocation.setY(blockLocation.getY() - i);
            }
            return counter == 3;
        }

    public Boolean isEquality(){
        return false;
    }
}
