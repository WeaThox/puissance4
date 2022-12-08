package fr.weathox.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class verifyColonne {


    Location verifyingLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);
    public Boolean isColonneFree(int colonne){

        verifyingLocation.setX(colonne);
        for(int i = 111; i != 105; i--){
            verifyingLocation.setY(i);
            if(verifyingLocation.getBlock().getType() == Material.AIR){
                return true;
            }
        }
        return false;

    }

}
