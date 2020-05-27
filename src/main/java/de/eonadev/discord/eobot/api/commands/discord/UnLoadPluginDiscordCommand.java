package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import de.eonadev.discord.eobot.api.commands.base.ResponseTemplate;
import de.eonadev.discord.eobot.api.plugin.EoBotPlugin;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

@CommandInfo(cmd = "unloadplugin", description = "Unload specified plugin")
public class UnLoadPluginDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        if (args.length != 1){
            ResponseTemplate.help(message).setText("Usage: reloadplugin <PluginName>").setDeletionTime(5).send(true);
            return;
        }
        EoBotPlugin eoBotPlugin = EoBot.getInstance().getPluginManager().getPlugin(args[0].toLowerCase());
        if(eoBotPlugin == null){
            ResponseTemplate.error(message).setText("Plugin \""+args[0]+"\" couldn't be found!").setDeletionTime(5).send(true);
            return;
        }
        Response response = new Response(message);
        response.setText("Unloading " + args[0]+ "..").setDeletionTime(-1L).send(false);
        EoBot.getInstance().getPluginManager().unloadPlugin(eoBotPlugin);
    }
}
