package fr.weathox.manager.winCondition;

import org.bukkit.Location;

public class manager {


    public static Boolean equalityStatut = false;

    public Boolean hasPlayerWin(Location blockLocation){

        if(horizontale(blockLocation)){
            return true;
        }else if(verticale(blockLocation)){
            return true;
        }else if(diagonale(blockLocation)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean horizontale(Location blockLocation){

        int counter = 0;

        for(int i = 1; i < 4; i ++){
            Location getLocation = blockLocation;
            getLocation.setX(blockLocation.getX() + i);
            if(blockLocation.getBlock().getData() == getLocation.getBlock().getData()){
                counter += 1;
            }
        }
        if(counter == 3){
            return true;
        }
        counter = 0;
        for(int i = -1; i > -3; i ++){
            Location getLocation = blockLocation;
            getLocation.setX(blockLocation.getX() + i);
            if(blockLocation.getBlock().getData() == getLocation.getBlock().getData()){
                counter += 1;
            }
        }
        if(counter == 3){
            return true;
        }
        return false;

    }

    public Boolean verticale(Location blockLocation){
        int counter = 0;

        for(int i = 1; i < 4; i ++){
            Location getLocation = blockLocation;
            getLocation.setX(blockLocation.getY() + i);
            if(blockLocation.getBlock().getData() == getLocation.getBlock().getData()){
                counter += 1;
            }
        }
        if(counter == 3){
            return true;
        }
        counter = 0;
        for(int i = -1; i > -3; i ++){
            Location getLocation = blockLocation;
            getLocation.setX(blockLocation.getY() + i);
            if(blockLocation.getBlock().getData() == getLocation.getBlock().getData()){
                counter += 1;
            }
        }
        if(counter == 3){
            return true;
        }
        return false;
    }

    public Boolean diagonale(Location blockLocation){

    }

    public Boolean isEquality(){

    }
}
