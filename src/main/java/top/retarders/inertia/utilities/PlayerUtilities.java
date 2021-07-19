package top.retarders.inertia.utilities;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerUtilities {

  public static void reset(Player player) {
    player.getInventory().clear();
    player.getInventory().setArmorContents(new ItemStack[] {null, null, null, null});

    player.getActivePotionEffects().forEach(effect -> player.removePotionEffect(effect.getType()));

    // clear arrows somehow
  }
}
