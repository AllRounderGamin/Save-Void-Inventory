package allroundergamin.savevoidinventory.commands;

import allroundergamin.savevoidinventory.SaveVoidInventory;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class toggleSaveVoidInv implements CommandExecutor {

    private final SaveVoidInventory plugin;
    private final FileConfiguration config;

    public toggleSaveVoidInv(SaveVoidInventory saveVoidInventory) {
        plugin = saveVoidInventory;
        config = saveVoidInventory.getConfig();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String [] args){
        boolean opt = config.getBoolean("SaveVoidInventory");
        config.set("SaveVoidInventory", !opt);
        plugin.saveConfig();

        Player player = (Player) sender;
        player.sendMessage("Save Void Inventory set to" + opt);
        Bukkit.getLogger().info("Save Void Inventory set to " + opt);

        return true;
    }
}
