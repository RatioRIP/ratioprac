package rip.ratio.ratioprac.preferences;

import org.bukkit.inventory.ItemStack;

public class Preference<T> {

  public final T _default;
  public final String name;
  public final ItemStack displayItem;

  public Preference(String name, ItemStack displayItem, T _default) {
    this.name = name;
    this.displayItem = displayItem;
    this._default = _default;
  }

  protected T next(T current) {
    return null;
  }

  // TODO: .
  public ItemStack render() {
    return null;
  }
}
