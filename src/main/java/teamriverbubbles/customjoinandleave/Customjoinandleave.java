/* Copyright (C) Xavier Horwood - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the GPL-3.0 license.
 *
 * You should have received a copy of the XYZ license with
 * this file. If not, please write to: license@teamriverbubbles.com, or visit :
 */

package teamriverbubbles.customjoinandleave;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Customjoinandleave extends JavaPlugin implements Listener {

    FileConfiguration config = getConfig();
    boolean enablePlaceholderAPI = true;

    @Override
    public void onEnable() {
        config.addDefault("CommandToRun", "say Hello %player_name%!");
        config.options().copyDefaults(true);
        saveConfig();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            enablePlaceholderAPI = false;
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
        }
    }

    // This method checks for incoming players and sends them a message
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        //if player has permission exempt
        if (event.getPlayer().hasPermission("customjoinandleave.exempt")) {
            return;
        }

        Player player = event.getPlayer();
        String command = config.getString("CommandToRun");

        //if PlaceholderAPI is enabled
        assert command != null;
        if(!enablePlaceholderAPI) {
            //replace placeholders with values and send message
            command = command.replace("%player_name%", player.getName());
            command = command.replace("%player_uuid%", player.getUniqueId().toString());
        }
        else
        {
            //set placeholders and run command
            command = PlaceholderAPI.setPlaceholders(event.getPlayer(), command);
        }
        player.performCommand(command);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //save config
        saveConfig();
        //print to console
        getLogger().info("Plugin has been disabled!");
    }
}
