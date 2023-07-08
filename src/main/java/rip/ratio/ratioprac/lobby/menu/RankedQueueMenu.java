package rip.ratio.ratioprac.lobby.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import rip.ratio.ratioprac.menu.Menu;
import rip.ratio.ratioprac.utilities.ItemBuilder;

public class RankedQueueMenu implements Menu {

  public static RankedQueueMenu instance;

  private Inventory inventory;

  public RankedQueueMenu() {
    instance = this;

    this.init();
  }

  @Override
  public void init() {
    this.inventory = Bukkit.createInventory(null, 2 * 9, "Ranked Queues");
  }

  @Override
  public void render() {
    this.inventory.clear();
    this.inventory.setItem(0, new ItemStack(Material.POTION));
    ItemStack potion = new ItemBuilder(Material.POTION)
            .displayname("NoDebuff")
            .lore(ChatColor.WHITE + "Playing" + ChatColor.GRAY + ": ")
            .lore(ChatColor.WHITE + "Waiting" + ChatColor.GRAY + ": ")
            .build();
  }

  @Override
  public boolean shouldRender() {
    return inventory.getViewers().size() != 0;
  }

  @Override
  public void onClick(InventoryClickEvent event) {
    if (event.getCurrentItem().getType() == Material.POTATO) {
      event.getWhoClicked().sendMessage(ChatColor.DARK_AQUA + "You have joined the" + ChatColor.WHITE + " Ranked Queue");
    }
  }

  @Override
  public Inventory getInventory() {
    return this.inventory;
  }
}
