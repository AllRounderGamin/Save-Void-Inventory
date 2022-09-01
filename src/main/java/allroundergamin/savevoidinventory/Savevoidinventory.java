package allroundergamin.savevoidinventory;

import allroundergamin.savevoidinventory.commands.toggleSaveVoidInv;
import allroundergamin.savevoidinventory.listeners.VoidDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SaveVoidInventory extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Save Void Inventory Enabled");

        new VoidDeathListener(this);

    }

    @Override
    public void onDisable() {
    }
}
