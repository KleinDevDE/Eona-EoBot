package de.eonadev.discord.eobot.api.commands.console;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;

import java.io.File;
@CommandInfo(cmd = "loadplugin")
public class LoadPluginConsoleCommand extends ConsoleCommand {
    @Override
    public void run(String[] args) {
        if (args.length != 1){
            Logger.log(LogType.INFO, "Usage: loadplugin <Plugin-File>");
            return;
        }
        if (!args[0].endsWith(".jar"))
            args[0] = args[0]+".jar";
        File plugin = new File(EoBot.getInstance().getEoBotConfiguration().pluginsFolder+"/"+args[0]);
        if (!plugin.exists()){
            Logger.log(LogType.ERROR, "Plugin \""+args[0]+"\" couldn't be found!");
            return;
        }
        EoBot.getInstance().getPluginManager().loadPlugin(plugin);
    }
}
