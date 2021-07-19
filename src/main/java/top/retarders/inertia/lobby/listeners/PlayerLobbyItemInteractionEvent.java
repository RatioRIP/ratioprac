package top.retarders.inertia.lobby.listeners;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import top.retarders.inertia.Fucking;
import top.retarders.inertia.lobby.item.LobbyItem;
import top.retarders.inertia.player.PracticePlayer;
import top.retarders.inertia.player.state.PracticePlayerState;

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
