package de.eonadev.discord.eobot.api.commands.console;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.utils.logging.Logger;

@CommandInfo(cmd = "reload")
public class ReloadConsoleCommand extends ConsoleCommand {
    @Override
    public void run(String[] args) {
        EoBot.getInstance().getEoBotConfiguration().reload();
        Logger.log("Config reloaded");
    }
}
