package me.rimon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.rimon.ABCD.flyers;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("Beta.fly")) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RED + "You do not have permission to use this command");
            return false;
        }
        if (flyers.contains(player.getUniqueId())) {
            player.setAllowFlight(false);
            flyers.remove(player.getUniqueId());
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] "  + ChatColor.YELLOW + "You have " + ChatColor.RED + "disabled " + ChatColor.YELLOW + "flight");
        } else {
            flyers.add(player.getUniqueId());
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] "  + ChatColor.YELLOW + "You have " + ChatColor.GREEN + "enabled " + ChatColor.YELLOW + "flight");
        }

        return true;
    }
}

