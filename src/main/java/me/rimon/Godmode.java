package me.rimon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.rimon.ABCD.thanos;

public class Godmode implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("Beta.God")) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RED + "You do not have permission to use this command");
            return false;
        }
        if (thanos.contains(player.getUniqueId())) {
            player.setInvulnerable(false);
            thanos.remove(player.getUniqueId());
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "You have " + ChatColor.RED + "disabled " + ChatColor.YELLOW + "GodMode");
        } else {
            thanos.add(player.getUniqueId());
            player.setInvulnerable(true);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "You have " + ChatColor.GREEN + "enabled " + ChatColor.YELLOW + "GodMode");
        }

        return true;
    }
}
