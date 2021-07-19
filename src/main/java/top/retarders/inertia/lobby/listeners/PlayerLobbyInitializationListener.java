package top.retarders.inertia.lobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import top.retarders.inertia.Fucking;
import top.retarders.inertia.utilities.PlayerUtilities;

public class PlayerLobbyInitializationListener implements Listener {

  @EventHandler()
  public void onJoin(PlayerJoinEvent event) throws Exception {
    Player player = event.getPlayer();

    //        while(Fucking.practicePlayerRepository.find(player.getUniqueId()) == null) {
    //            continue;
    //        }

    // reset the player (effects, armor, inventory)
    PlayerUtilities.reset(player);

    // teleport to spawn on world "world"
    player.teleport(Bukkit.getWorld("world").getSpawnLocation());

    // give lobby items
    Fucking.practicePlayerRepository.find(player.getUniqueId()).giveLobbyItems();
  }
}
