package allroundergamin.savevoidinventory.listeners;

import allroundergamin.savevoidinventory.SaveVoidInventory;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;


import java.util.Objects;


public class VoidDeathListener implements Listener {

    private final FileConfiguration config;


    public VoidDeathListener(SaveVoidInventory plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        config = plugin.getConfig();
    }

    @EventHandler
    public void onVoidDeath(PlayerDeathEvent event) {
        if (config.getBoolean("SaveVoidInventory")) {
            EntityDamageEvent.DamageCause deathCause = Objects.requireNonNull(event.getPlayer().getLastDamageCause()).getCause();
            if (EntityDamageEvent.DamageCause.VOID != deathCause) {
                return;
            }
            if (!event.getKeepInventory()) {
                event.setKeepInventory(true);
                event.setKeepLevel(true);
                event.getDrops().clear();
                event.setShouldDropExperience(false);
            }
        }
    }
}