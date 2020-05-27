package de.eonadev.discord.eobot.api.commands.console;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.api.plugin.EoBotPlugin;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;

@CommandInfo(cmd = "unloadplugin")
public class UnLoadPluginConsoleCommand extends ConsoleCommand {
    @Override
    public void run(String[] args) {
        if (args.length != 1){
            Logger.log(LogType.INFO, "Usage: unloadplugin <PluginName>");
            return;
        }
        Logger.log(LogType.DEBUG, "args[0] " + args[0]); //TODO remove DEBUG
        EoBotPlugin eoBotPlugin = EoBot.getInstance().getPluginManager().getPlugin(args[0].toLowerCase());
        Logger.log(LogType.DEBUG, "Plugin name " + eoBotPlugin.getPluginDescription().getPluginName()); //TODO remove DEBUG
        if(eoBotPlugin == null){
            Logger.log(LogType.ERROR, "Plugin \""+args[0]+"\" couldn't be found!");
            return;
        }
        EoBot.getInstance().getPluginManager().unloadPlugin(eoBotPlugin);
    }
}
