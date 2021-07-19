package top.retarders.inertia.lobby.item;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public interface LobbyItem {

  ItemStack render(Player player);

  int getSlot();

  boolean matches(ItemStack itemStack);

  void onInteract(Player player, Action action);
}
