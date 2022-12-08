package fr.weathox.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class verifyColonne {


    Location verifyingLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);
    public Boolean isColonneFree(int colonne){

        for(int i = 6; i != 0; i--){
            verifyingLocation.setX(colonne);
            if(verifyingLocation.getBlock().getType() == null){
                return true;
            }
        }
        return false;

    }

}
