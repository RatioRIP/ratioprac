package top.retarders.inertia.menu;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public interface Menu {

  void init();

  void render();

  boolean shouldRender();

  void onClick(InventoryClickEvent event);

  Inventory getInventory();
}
