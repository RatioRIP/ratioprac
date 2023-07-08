package rip.ratio.ratioprac.commands;

import me.vaperion.blade.annotation.argument.Sender;
import me.vaperion.blade.annotation.command.Async;
import me.vaperion.blade.annotation.command.Command;
import me.vaperion.blade.annotation.command.Description;
import org.bukkit.entity.Player;

public class Test {

    @Command("test")
    @Description("test command")
    @Async
    public static void test (@Sender Player player) {
        player.sendMessage("test");
    }
}
