package top.retarders.inertia.utilities;

import org.bukkit.ChatColor;

public class ColorUtilities {

  public static String colorize(String string) {
    return ChatColor.translateAlternateColorCodes('&', string);
  }
}
