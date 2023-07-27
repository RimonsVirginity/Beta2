package me.rimon;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Adventure implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("Beta.Adventure")) {
                if (player.getGameMode() == GameMode.ADVENTURE) {
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "You are already in Adventure mode");
                } else {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "Your gamemode has been set to Adventure");
                }
            } else {
                player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RED + "You do not have permission to use this command");
            }
        }

        return false;
    }

}

