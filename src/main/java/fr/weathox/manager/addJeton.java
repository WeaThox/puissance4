package fr.weathox.manager;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Objects;

public class addJeton {

    public static Location blockPoseLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);
    public static void poseBlock(String player, int colonne, Player Player){
        blockPoseLocation.setX(colonne);
        for(int i = 111; i != 105; i--){
            blockPoseLocation.setY(i);
            if(blockPoseLocation.getBlock().getType() == null){
                blockPoseLocation.getBlock().setType(Material.WOOL);
                if(Objects.equals(player, register.player1name)) {
                    blockPoseLocation.getBlock().setData(DyeColor.RED.getData());
                }else{
                    blockPoseLocation.getBlock().setData(DyeColor.YELLOW.getData());
                }
                new start().startGame(Player, register.player1name, register.player2name);
            }
        }

    }

}
