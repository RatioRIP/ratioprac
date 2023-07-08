package rip.ratio.ratioprac.menu;

import rip.ratio.ratioprac.Fucking;

public class MenuRenderTask implements Runnable {
  @Override
  public void run() {
    Fucking.menus.stream().filter(Menu::shouldRender).forEach(Menu::render);
  }
}
