package allroundergamin.savevoidinventory;

import allroundergamin.savevoidinventory.commands.toggleSaveVoidInv;
import allroundergamin.savevoidinventory.listeners.VoidDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class SaveVoidInventory extends JavaPlugin {

    private final File config = new File(getDataFolder(), "config.yml");

    @Override
    public void onEnable() {

        if (!config.exists()){
            saveDefaultConfig();
        }

        getCommand("toggleSaveVoidInv").setExecutor(new toggleSaveVoidInv(this));

        new VoidDeathListener(this);

        boolean pluginStatus = getConfig().getBoolean("SaveVoidInventory");
        if (pluginStatus) {
            Bukkit.getLogger().info("Save Void Inventory Loaded, Currently Enabled");
        } else {
            Bukkit.getLogger().info("Save Void Inventory Loaded, Currently Disabled");
        }

    }

    @Override
    public void onDisable() {
    }
}
