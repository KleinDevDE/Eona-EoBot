package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import de.eonadev.discord.eobot.api.commands.base.ResponseTemplate;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

import java.io.File;

@CommandInfo(cmd = "loadplugin", permission = "eobot.system.loadplugin", description = "Load a plugin")
public class LoadPluginDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        if (args.length != 1){
            ResponseTemplate.help(message).setText("Usage: loadplugin <Plugin-File>").setDeletionTime(5).send(true);
            return;
        }
        if (!args[0].endsWith(".jar"))
            args[0] = args[0]+".jar";
        File plugin = new File(EoBot.getInstance().getEoBotConfiguration().pluginsFolder+"/"+args[0]);
        if (!plugin.exists()){
            ResponseTemplate.error(message).setText("Plugin \""+args[0]+"\" couldn't be found!").setDeletionTime(5).send(true);
            return;
        }
        Response response = new Response(message);
        response.setText("Loading " + plugin.getName() + "..").setDeletionTime(-1L).send(false);
        EoBot.getInstance().getPluginManager().loadPlugin(plugin);
    }
}
