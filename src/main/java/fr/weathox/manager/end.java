package fr.weathox.manager;

import fr.weathox.Puissance;
import fr.weathox.manager.winCondition.manager;
import fr.weathox.utils.NMSUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class end {

    Location initialLocation = new Location(Bukkit.getWorld("world"), 0, 105,  0);

    public void endParty(String player, Player Player){
        for(int i = 1; i <8; i++){
            initialLocation.setX(i);
            for(int j = 106; j < 112; j++){
                initialLocation.setY(j);
                initialLocation.getBlock().setType(Material.AIR);
            }

        }
        if(manager.equalityStatut){
            NMSUtils.sendTitle(Player, "§bEgalité !", "§fLa partie est terminée.", 1, 3, 1);
            manager.equalityStatut = false;
            start.statutGame = false;
        }else {
            NMSUtils.sendTitle(Player, "§aGagné !", "§b" + player + "§f a gagné la partie", 1, 3, 1);
        }
        Player.sendMessage(Puissance.prefix + "§fpour relancer une partie : §b/start");

    }

}
