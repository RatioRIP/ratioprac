package rip.ratio.ratioprac.utilities;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;

public class PlayerUtilities {

  public static void reset(Player player) {
    player.getInventory().clear();
    player.getInventory().setArmorContents(new ItemStack[] {null, null, null, null});

    player.getActivePotionEffects().forEach(effect -> player.removePotionEffect(effect.getType()));

    // clear arrows somehow
  }

  public static int ping(Player player) {
    int ping = 0;

    try {

      Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
      ping = entityPlayer.getClass().getField("ping").getInt(entityPlayer);

    } catch (Exception e) {}

    return ping;
  }
}
