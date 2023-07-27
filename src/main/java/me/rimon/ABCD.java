package me.rimon;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public final class ABCD extends JavaPlugin {

    public static HashSet<UUID> flyers = new HashSet<>();
    public static HashSet<UUID> thanos = new HashSet<>();
    public static HashMap<UUID, BetaTeleport> requests = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
    getCommand("Fly").setExecutor(new Fly());
    getCommand("Creative").setExecutor(new Creative());
    getCommand("Survival").setExecutor(new Survival());
    getCommand("Adventure").setExecutor(new Adventure());
    getCommand("Spectator").setExecutor(new Spectator());
    getCommand("Godmode").setExecutor(new Godmode());
    getCommand("Smite").setExecutor(new Smite());
    getCommand("Tpaccept").setExecutor(new TeleportAccept());
    getCommand("Tpa").setExecutor(new TeleportRequest());
    getCommand("Tpdeny").setExecutor(new TeleportDeny());



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
