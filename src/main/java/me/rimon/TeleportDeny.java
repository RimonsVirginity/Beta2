package me.rimon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.rimon.ABCD.requests;

public class TeleportDeny implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            return false;
        }
        Player player = (Player) sender;
        if (!requests.containsKey(player.getUniqueId())) {
            player.sendMessage("nobody likes you");
            return false;
        }
        BetaTeleport tp = requests.get(player.getUniqueId());
        tp.deny();
        return true;
    }
}
