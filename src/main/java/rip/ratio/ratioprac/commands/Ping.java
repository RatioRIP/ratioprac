package rip.ratio.ratioprac.commands;

import me.vaperion.blade.annotation.argument.Name;
import me.vaperion.blade.annotation.argument.Optional;
import me.vaperion.blade.annotation.argument.Sender;
import me.vaperion.blade.annotation.command.Async;
import me.vaperion.blade.annotation.command.Command;
import me.vaperion.blade.annotation.command.Description;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import rip.ratio.ratioprac.utilities.PlayerUtilities;

public class Ping {

    @Command({"ping", "latency", "ms"})
    @Description("shows the latency of the sender/target")
    public static void ping (@Sender Player player, @Name("target") @Optional("self") Player target) {
        int ping = PlayerUtilities.ping(target);

        if (target == player) {
            player.sendMessage(ChatColor.DARK_AQUA + "You have a ping of " + ChatColor.WHITE + ping + ChatColor.DARK_AQUA + " ms.");
        } else {
            player.sendMessage(ChatColor.WHITE + target.getName() + ChatColor.DARK_AQUA + " has a ping of " + ChatColor.WHITE + ping + ChatColor.DARK_AQUA + " ms.");
        }

    }
}
