package top.retarders.inertia.menu;

import java.util.Optional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import top.retarders.inertia.Fucking;

public class MenuInteractionListener implements Listener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Optional<Menu> menuOptional = Fucking.menus.stream()
        .filter(m -> m.getInventory().equals(event.getClickedInventory()))
        .findFirst();

    if (menuOptional.isPresent()) {
      Menu menu = menuOptional.get();

      event.setCancelled(true);

      menu.onClick(event);
    }
  }
}