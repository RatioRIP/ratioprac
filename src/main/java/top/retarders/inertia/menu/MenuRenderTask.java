package top.retarders.inertia.menu;

import top.retarders.inertia.Fucking;

public class MenuRenderTask implements Runnable {
  @Override
  public void run() {
    Fucking.menus.stream().filter(Menu::shouldRender).forEach(Menu::render);
  }
}
