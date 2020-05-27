package de.eonadev.discord.eobot.api.commands.console;

import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.utils.ApplicationManager;
import de.eonadev.discord.eobot.utils.logging.Logger;

import java.io.IOException;

@CommandInfo(cmd = "reboot")
public class RebootConsoleCommand extends ConsoleCommand {
    @Override
    public void run(String[] args) {
        try {
            Logger.log("Restarting..");
            ApplicationManager.restartApplication(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
