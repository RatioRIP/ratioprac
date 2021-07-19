package top.retarders.inertia;

import java.util.Arrays;
import java.util.Collection;
import top.retarders.inertia.duel.preferences.DuelRequestsPreference;
import top.retarders.inertia.lobby.item.LobbyItem;
import top.retarders.inertia.lobby.items.UnrankedQueueItem;
import top.retarders.inertia.lobby.menu.UnrankedQueueMenu;
import top.retarders.inertia.menu.Menu;
import top.retarders.inertia.player.repository.PracticePlayerRepository;
import top.retarders.inertia.preferences.Preference;

public class Fucking {

  /**
   * Practice Player Repository
   */
  public static final PracticePlayerRepository practicePlayerRepository =
      new PracticePlayerRepository();

  /**
   * Lobby Items
   */
  public static final Collection<LobbyItem> lobbyItems = Arrays.asList(
      new UnrankedQueueItem()
  );

  /**
   * Menus
   */
  public static final Collection<Menu> menus = Arrays.asList(
      new UnrankedQueueMenu()
  );

  /**
   * Preferences
   */
  public static final Collection<Preference> preferences = Arrays.asList(
      new DuelRequestsPreference()
  );
}
