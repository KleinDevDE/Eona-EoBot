package de.eonadev.discord.eobot.api.commands.console;

import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.utils.logging.Logger;

@CommandInfo(cmd = "stop", aliases = {"exit", "end", "poweroff", "shutdown"})
public class ShutdownConsoleCommand extends ConsoleCommand {
    @Override
    public void run(String[] args) {
        Logger.log("Shutting down..");
        System.exit(0);
    }
}
