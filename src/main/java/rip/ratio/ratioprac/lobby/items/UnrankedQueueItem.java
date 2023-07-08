package rip.ratio.ratioprac.lobby.items;

import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import rip.ratio.ratioprac.lobby.menu.UnrankedQueueMenu;
import rip.ratio.ratioprac.lobby.item.LobbyItem;

public class UnrankedQueueItem implements LobbyItem {

  private final ItemStack item;

  public UnrankedQueueItem() {
    // initialize item for caching purposes
    this.item = new ItemStack(Material.IRON_SWORD);

    ItemMeta itemMeta = this.item.getItemMeta();
    itemMeta.setDisplayName(ChatColor.WHITE + "Unranked Queue");
    this.item.setItemMeta(itemMeta);
  }

  @Override
  public ItemStack render(Player player) {
    // there is a slight chance that we might need to clone this
    return this.item;
  }

  @Override
  public int getSlot() {
    return 1;
  }

  @Override
  public boolean matches(ItemStack itemStack) {
    return itemStack.isSimilar(this.item);
  }

  @Override
  public void onInteract(Player player, Action action) {
    if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
      player.openInventory(UnrankedQueueMenu.instance.getInventory());
    }
  }
}
