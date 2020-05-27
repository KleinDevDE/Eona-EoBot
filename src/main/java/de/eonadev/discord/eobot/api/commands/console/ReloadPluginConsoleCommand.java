package de.eonadev.discord.eobot.api.commands.console;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.api.plugin.EoBotPlugin;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;

@CommandInfo(cmd = "reloadplugin")
public class ReloadPluginConsoleCommand extends ConsoleCommand {
    @Override
    public void run(String[] args) {
        if (args.length != 1){
            Logger.log(LogType.INFO, "Usage: reloadplugin <PluginName>");
            return;
        }
        EoBotPlugin eoBotPlugin = EoBot.getInstance().getPluginManager().getPlugin(args[0].toLowerCase());
        if(eoBotPlugin == null){
            Logger.log(LogType.ERROR, "Plugin \""+args[0]+"\" couldn't be found!");
            return;
        }
        EoBot.getInstance().getPluginManager().unloadPlugin(eoBotPlugin);
        EoBot.getInstance().getPluginManager().loadPlugin(EoBotPlugin.getPluginFile());
    }
}
