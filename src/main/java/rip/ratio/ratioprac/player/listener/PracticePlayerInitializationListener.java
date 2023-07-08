package rip.ratio.ratioprac.player.listener;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import rip.ratio.ratioprac.Fucking;
import rip.ratio.ratioprac.player.PracticePlayer;
import org.bukkit.entity.Player;

public class PracticePlayerInitializationListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) throws Exception {
    UUID uuid = event.getPlayer().getUniqueId();

    final String[] WELCOME_MESSAGE = {
            "&7&m---------------------------------",
            "",
            "&3Welcome to &fRatio Practice",
            "",
            "&3Website&7: &fhttps://ratio.rip",
            "&3Discord&7: &fhttps://discord.com/ratiorip",
            "&3Twitter&7: &fhttps://twitter.com/RatioRIP",
            "",
            "&7&m---------------------------------"
    };

    for (String line : WELCOME_MESSAGE) {
      Player player = event.getPlayer();
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
    }

    if (Fucking.practicePlayerRepository.find(uuid) != null) {
      // WHAT THE FUCK?
      throw new Exception("why the fuck is " + uuid + " still in the repository?");
    }

    Fucking.practicePlayerRepository.insert(uuid, new PracticePlayer(uuid));
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    UUID uuid = event.getPlayer().getUniqueId();

    Fucking.practicePlayerRepository.remove(uuid);
  }
}
