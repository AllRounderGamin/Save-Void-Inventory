package allroundergamin.savevoidinventory.commands;

import allroundergamin.savevoidinventory.SaveVoidInventory;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class toggleSaveVoidInv implements CommandExecutor {

    private final SaveVoidInventory plugin;
    private final FileConfiguration config;

    public toggleSaveVoidInv(SaveVoidInventory saveVoidInventory) {
        plugin = saveVoidInventory;
        config = saveVoidInventory.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        boolean newOpt = !(config.getBoolean("SaveVoidInventory"));
        config.set("SaveVoidInventory", newOpt);
        plugin.saveConfig();

        Player player = (Player) sender;
        player.sendMessage("Save Void Inventory set to " + newOpt);
        Bukkit.getLogger().info("Save Void Inventory set to " + newOpt);

        return true;
    }
}
