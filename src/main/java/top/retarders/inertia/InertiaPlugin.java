package top.retarders.inertia;

import java.io.IOException;
import org.bukkit.plugin.java.JavaPlugin;
import top.retarders.inertia.configuration.ConfigurationLoader;
import top.retarders.inertia.lobby.listeners.PlayerLobbyInitializationListener;
import top.retarders.inertia.lobby.listeners.PlayerLobbyItemInteractionEvent;
import top.retarders.inertia.menu.MenuInteractionListener;
import top.retarders.inertia.menu.MenuRenderTask;
import top.retarders.inertia.player.listener.PracticePlayerInitializationListener;

public class InertiaPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    // load config
    try {
      new ConfigurationLoader(this).load();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // register listeners
    this.getServer()
        .getPluginManager()
        .registerEvents(new PracticePlayerInitializationListener(), this);

    this.getServer()
        .getPluginManager()
        .registerEvents(new PlayerLobbyInitializationListener(), this);

    this.getServer()
        .getPluginManager()
        .registerEvents(new PlayerLobbyItemInteractionEvent(), this);

    this.getServer()
        .getPluginManager()
        .registerEvents(new MenuInteractionListener(), this);

    this.getServer().getScheduler()
        .scheduleSyncRepeatingTask(this, new MenuRenderTask(), 20L, 20L);
  }
}
