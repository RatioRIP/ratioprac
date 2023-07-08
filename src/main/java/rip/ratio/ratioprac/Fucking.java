package rip.ratio.ratioprac;

import java.util.Arrays;
import java.util.Collection;

import rip.ratio.ratioprac.player.repository.PracticePlayerRepository;
import rip.ratio.ratioprac.duel.preferences.DuelRequestsPreference;
import rip.ratio.ratioprac.lobby.item.LobbyItem;
import rip.ratio.ratioprac.lobby.items.UnrankedQueueItem;
import rip.ratio.ratioprac.lobby.menu.UnrankedQueueMenu;
import rip.ratio.ratioprac.menu.Menu;
import rip.ratio.ratioprac.preferences.Preference;

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
