package me.rimon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Smite implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player smiter = (Player) sender;
            if (!smiter.hasPermission("Beta.Smite")) {
                smiter.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RED + "You do not have permission to use this command");
            } else if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) == null) {
                    smiter.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "This player is not online");
                    return true;
                }
                Player smited = Bukkit.getPlayer(args[0]);
                smited.getWorld().strikeLightning(smited.getLocation());
                smited.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RED + smiter.getName() + ChatColor.YELLOW + " has Smited you!");
                smiter.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "you have smited " + smited.getName());
            }
            if (args.length != 1) {
                smiter.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "/Smite (player)");
                return true;
            }
        }
        return true;
    }
}




