package top.retarders.inertia.lobby.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import top.retarders.inertia.menu.Menu;

public class UnrankedQueueMenu implements Menu {

  public static UnrankedQueueMenu instance;

  private Inventory inventory;

  public UnrankedQueueMenu() {
    instance = this;

    this.init();
  }

  @Override
  public void init() {
    this.inventory = Bukkit.createInventory(null, 2 * 9, "Unranked Queues");
  }

  @Override
  public void render() {
    this.inventory.clear();
    this.inventory.setItem(0, new ItemStack(Material.GOLD_AXE));
  }

  @Override
  public boolean shouldRender() {
    return inventory.getViewers().size() != 0;
  }

  @Override
  public void onClick(InventoryClickEvent event) {
    if (event.getCurrentItem().getType() == Material.GOLD_AXE) {
      event.getWhoClicked().sendMessage(ChatColor.YELLOW + "Feelin good.");
    }
  }

  @Override
  public Inventory getInventory() {
    return this.inventory;
  }
}
