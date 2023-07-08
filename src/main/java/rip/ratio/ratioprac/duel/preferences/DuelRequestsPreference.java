package rip.ratio.ratioprac.duel.preferences;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import rip.ratio.ratioprac.preferences.Preference;

public class DuelRequestsPreference extends Preference<Boolean> {

  public DuelRequestsPreference() {
    super("Duel Requests", new ItemStack(Material.DIAMOND_SWORD), true);
  }

  @Override
  protected Boolean next(Boolean current) {
    return !current;
  }
}
