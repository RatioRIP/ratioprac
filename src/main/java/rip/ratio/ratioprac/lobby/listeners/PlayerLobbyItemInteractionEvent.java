package rip.ratio.ratioprac.lobby.listeners;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import rip.ratio.ratioprac.Fucking;
import rip.ratio.ratioprac.player.state.PracticePlayerState;
import rip.ratio.ratioprac.lobby.item.LobbyItem;
import rip.ratio.ratioprac.player.PracticePlayer;

public class PlayerLobbyItemInteractionEvent implements Listener {

  @EventHandler
  public void onInteract(PlayerInteractEvent event) {
    UUID uuid = event.getPlayer().getUniqueId();
    PracticePlayer practicePlayer = Fucking.practicePlayerRepository.find(uuid);

    if (event.getItem() == null) {
      return;
    }

    if (practicePlayer.state == PracticePlayerState.LOBBY) {
      Optional<LobbyItem> lobbyItem =
          Fucking.lobbyItems.stream().filter(item -> item.matches(event.getItem())).findFirst();

      if (!lobbyItem.isPresent()) return;

      lobbyItem.get().onInteract(event.getPlayer(), event.getAction());
    }
  }
}
