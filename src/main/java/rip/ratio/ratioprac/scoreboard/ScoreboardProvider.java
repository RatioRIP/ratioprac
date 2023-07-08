package rip.ratio.ratioprac.scoreboard;

import io.github.thatkawaiisam.assemble.AssembleAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements AssembleAdapter {
    @Override
    public String getTitle(Player player) {
        return "&3Practice &7[BETA]";
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> list = new ArrayList();
        list.add("&7&m---------------");
        list.add(ChatColor.DARK_AQUA + "Players&7: " + ChatColor.WHITE +Bukkit.getOnlinePlayers().size());
        list.add(ChatColor.DARK_AQUA + "In-Match&7: ");
        list.add(ChatColor.DARK_AQUA + "In-Queue&7: ");
        list.add("");
        list.add(ChatColor.GRAY + "&oratio.rip");
        list.add("&7&m---------------");
        return list;
    }
}
