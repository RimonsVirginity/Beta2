package me.rimon;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;
import static me.rimon.ABCD.requests;

public class BetaTeleport {

    public UUID playerUUID;
    public UUID targetUUID;
    public Location location;

    public Player player() {
        try {
            return Bukkit.getPlayer(playerUUID);
        } catch(NullPointerException e) {
            return null;
        }
    }

    public Player target() {
        try {
            return Bukkit.getPlayer(targetUUID);
        } catch(NullPointerException e) {
            return null;
        }
    }

    public BetaTeleport(UUID playerUUID, UUID targetUUID, Location location) {
        this.playerUUID = playerUUID;
        this.targetUUID = targetUUID;
        this.location = location;
    }

    public void sendRequest() {
        requests.put(targetUUID, this);
        target().sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.WHITE + player().getName() + ChatColor.YELLOW +  " has requested to teleport to you!");
        target().sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.GREEN + "/tpaccept" + ChatColor.YELLOW + " to accept teleport");
        target().sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RED + "/tpdeny" + ChatColor.YELLOW + " to deny teleport");
    }

    public void accept() {
        requests.remove(targetUUID, this);
        player().teleport(location);
        player().sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.WHITE + target().getName() + ChatColor.YELLOW +  " has " +  ChatColor.GREEN + "accepted" + ChatColor.YELLOW + " your teleport request!");
    }

    public void deny() {
        requests.remove(targetUUID, this);
        player().sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.WHITE + target().getName() + ChatColor.YELLOW +  " has " +  ChatColor.RED + "denied" + ChatColor.YELLOW + " your teleport request!");
    }

}
