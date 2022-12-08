package fr.weathox.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class verifyColonne {


    Location verifyingLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);

    public Boolean isColonneFree(int colonne){
        // On crée une nouvelle Location en utilisant la colonne spécifiée et en spécifiant les coordonnées Y et Z par défaut
        verifyingLocation.setX(colonne);

        // On itère de 111 à 105 pour vérifier chaque bloc de la colonne
        for(int i = 111; i != 105; i--){
            verifyingLocation.setY(i);

            // Si le bloc est de type AIR, la colonne est libre
            if(verifyingLocation.getBlock().getType() == Material.AIR){
                return true;
            }
        }

        // Si aucun bloc n'est de type AIR, la colonne n'est pas libre
        return false;

    }


}
