package me.rimon;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.CREATIVE;

public class Creative implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
           Player player = (Player) sender;
        if (player.hasPermission("Beta.Creative")) {
        if(player.getGameMode() == GameMode.CREATIVE) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "You are already in creative mode");
        } else {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "Your gamemode has been set to creative");
        }
        } else {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RED + "You do not have permission to use this command");
        }
        }

return false;
    }

}
