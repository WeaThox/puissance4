package fr.weathox.zone;

import fr.weathox.listener.playerJoinEvent;
import jdk.javadoc.internal.doclint.HtmlTag;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;

public class creation {


    Location initialLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);
    public void mapCreation(){

        playerJoinEvent.spawnPlayer.getBlock().setType(Material.WOOL);
        initialLocation.getBlock().setType(Material.WOOL);
        initialLocation.getBlock().setData(DyeColor.BLUE.getData());
        for(int i = 0; i < 7; i++){

            initialLocation.setY(initialLocation.getY() + 1);
            initialLocation.getBlock().setType(Material.WOOL);
            initialLocation.getBlock().setData(DyeColor.BLUE.getData());

        }
        for(int i = 0; i < 8; i++){

            initialLocation.setX(initialLocation.getX() + 1);
            initialLocation.getBlock().setType(Material.WOOL);
            initialLocation.getBlock().setData(DyeColor.BLUE.getData());

        }
        for(int i = 0; i < 7; i++){

            initialLocation.setY(initialLocation.getY() - 1);
            initialLocation.getBlock().setType(Material.WOOL);
            initialLocation.getBlock().setData(DyeColor.BLUE.getData());

        }
        for(int i = 0; i < 8; i++){

            initialLocation.setX(initialLocation.getX() - 1);
            initialLocation.getBlock().setType(Material.WOOL);
            initialLocation.getBlock().setData(DyeColor.BLUE.getData());

        }

    }

}
