package rip.ratio.ratioprac;

import java.io.IOException;

import io.github.thatkawaiisam.assemble.Assemble;
import me.vaperion.blade.Blade;
import me.vaperion.blade.bukkit.BladeBukkitPlatform;
import org.bukkit.plugin.java.JavaPlugin;
import rip.ratio.ratioprac.commands.Ping;
import rip.ratio.ratioprac.commands.Test;
import rip.ratio.ratioprac.player.listener.PracticePlayerInitializationListener;
import rip.ratio.ratioprac.configuration.ConfigurationLoader;
import rip.ratio.ratioprac.lobby.listeners.PlayerLobbyInitializationListener;
import rip.ratio.ratioprac.lobby.listeners.PlayerLobbyItemInteractionEvent;
import rip.ratio.ratioprac.menu.MenuInteractionListener;
import rip.ratio.ratioprac.menu.MenuRenderTask;
import rip.ratio.ratioprac.scoreboard.ScoreboardProvider;

public class InertiaPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    Blade.forPlatform(new BladeBukkitPlatform(this))
            .config(cfg -> {
              cfg.setDefaultPermissionMessage("&cYou do not have pemission.");
            })
            .bind(binder -> {})
            .build()
            .register(Test.class)
            .register(Ping.class);

    // load config
    try {
      new ConfigurationLoader(this).load();
    } catch (IOException e) {
      e.printStackTrace();
    }

    Assemble assemble = new Assemble(this, new ScoreboardProvider());

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
