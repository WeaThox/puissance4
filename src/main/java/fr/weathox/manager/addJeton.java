package fr.weathox.manager;

import fr.weathox.manager.winCondition.manager;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

import java.util.Objects;

import static fr.weathox.manager.start.actualPlayer;

public class addJeton {

    public static Location blockPoseLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);
    public static void poseBlock(String player, int colonne, Player Player){
        blockPoseLocation.setX(colonne);
        for(int i = 105; i <112; i++){
            blockPoseLocation.setY(i);
            if(blockPoseLocation.getBlock().getType() == Material.AIR){
                if(Objects.equals(player, register.player1name)) {

                    blockPoseLocation.getBlock().setType(Material.STAINED_CLAY);
                    blockPoseLocation.getBlock().setData(DyeColor.RED.getData());

                }else{
                    Wool wool = new Wool(DyeColor.YELLOW);
                    blockPoseLocation.getBlock().setType(wool.getItemType());
                    blockPoseLocation.getBlock().setData(DyeColor.YELLOW.getData());
                }

                i = 112;
            }
        }
        if(new manager().hasPlayerWin(blockPoseLocation)){
            new end().endParty(actualPlayer, Player);
            return;
        }else if(new manager().isEquality()){

        }
        if(Objects.equals(actualPlayer, register.player1name)){
            actualPlayer = register.player2name;
        }else{
            actualPlayer = register.player1name;
        }
        new start().startGame(Player, register.player1name, register.player2name);

    }

}
