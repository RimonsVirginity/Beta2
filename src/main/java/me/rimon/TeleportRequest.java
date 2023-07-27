package me.rimon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportRequest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("Beta.tpa")) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RED + "You do not have permission to use this command");
            return false;
        }
        if (!(args.length == 1)) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "/tpa (player)");
            return false;
        }
        if (Bukkit.getPlayer(args[0]) == null) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + "This player is not online");
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        BetaTeleport tp = new BetaTeleport(player.getUniqueId(), target.getUniqueId(), target.getLocation());
        tp.sendRequest();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "Prime" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW + " you have sent a teleport request to " + ChatColor.WHITE + target.getName());
        return true;
    }
}
