package top.retarders.inertia.lobby.items;

import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import top.retarders.inertia.lobby.item.LobbyItem;
import top.retarders.inertia.lobby.menu.UnrankedQueueMenu;

public class UnrankedQueueItem implements LobbyItem {

  private final ItemStack item;

  public UnrankedQueueItem() {
    // initialize item for caching purposes
    this.item = new ItemStack(Material.STONE_SWORD);

    ItemMeta itemMeta = this.item.getItemMeta();
    itemMeta.setDisplayName(ChatColor.YELLOW + "Unranked Queue");
    itemMeta.setLore(Arrays.asList(
        ChatColor.GRAY
            + "Right click to open the "
            + ChatColor.WHITE
            + "Unranked Queue"
            + ChatColor.GRAY
            + " menu"
    ));

    this.item.setItemMeta(itemMeta);
  }

  @Override
  public ItemStack render(Player player) {
    // there is a slight chance that we might need to clone this
    return this.item;
  }

  @Override
  public int getSlot() {
    return 0;
  }

  @Override
  public boolean matches(ItemStack itemStack) {
    return itemStack.isSimilar(this.item);
  }

  @Override
  public void onInteract(Player player, Action action) {
    if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
      player.sendMessage(ChatColor.YELLOW
          + "Opening "
          + ChatColor.WHITE
          + "Unranked Queue"
          + ChatColor.YELLOW
          + " menu");

      player.openInventory(UnrankedQueueMenu.instance.getInventory());
    }
  }
}
