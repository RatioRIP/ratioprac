package rip.ratio.ratioprac.player.listener;

import java.util.UUID;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import rip.ratio.ratioprac.Fucking;
import rip.ratio.ratioprac.player.PracticePlayer;

public class PracticePlayerInitializationListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) throws Exception {
    UUID uuid = event.getPlayer().getUniqueId();

    if (Fucking.practicePlayerRepository.find(uuid) != null) {
      // WHAT THE FUCK?
      throw new Exception("why the fuck is " + uuid + " still in the repository?");
    }

    Fucking.practicePlayerRepository.insert(uuid, new PracticePlayer(uuid));
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    UUID uuid = event.getPlayer().getUniqueId();

    Fucking.practicePlayerRepository.remove(uuid);
  }
}
