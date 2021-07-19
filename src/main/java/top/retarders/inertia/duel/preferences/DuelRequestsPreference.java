package top.retarders.inertia.duel.preferences;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import top.retarders.inertia.preferences.Preference;

public class DuelRequestsPreference extends Preference<Boolean> {

  public DuelRequestsPreference() {
    super("Duel Requests", new ItemStack(Material.DIAMOND_SWORD), true);
  }

  @Override
  protected Boolean next(Boolean current) {
    return !current;
  }
}
