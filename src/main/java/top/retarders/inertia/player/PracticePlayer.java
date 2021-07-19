package top.retarders.inertia.player;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import top.retarders.inertia.Fucking;
import top.retarders.inertia.lobby.item.LobbyItem;
import top.retarders.inertia.player.state.PracticePlayerState;

public class PracticePlayer {

  public final UUID uuid;
  public final PracticePlayerState state;

  public PracticePlayer(UUID uuid) {
    this.uuid = uuid;
    this.state = PracticePlayerState.LOBBY;
  }

  public Player getPlayer() {
    // we don't store the player object because it's big as FUCK
    return Bukkit.getPlayer(this.uuid);
  }

  public void giveLobbyItems() {
    // don't remember why i didn't use foreach but i miss these loops man
    for (LobbyItem lobbyItem : Fucking.lobbyItems) {
      getPlayer().getInventory().setItem(lobbyItem.getSlot(), lobbyItem.render(getPlayer()));
    }
  }
}
