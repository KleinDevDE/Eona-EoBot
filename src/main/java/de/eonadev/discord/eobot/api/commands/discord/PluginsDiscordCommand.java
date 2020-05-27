package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

@CommandInfo(cmd = "plugins", permission = "eobot.system.plugins", description = "List all registered plugins")
public class PluginsDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        //TODO Sort alphabetic
        for (String s : EoBot.getInstance().getPluginManager().getActivePlugins()) {
            if (stringBuilder.toString().equals(""))
                stringBuilder.append(s);
            else stringBuilder.append(", ").append(s);
        }
        Response response = new Response(message);
        response.setTitle("Active plugins:");
        response.setText(stringBuilder.toString());
        response.send(true);
    }
}
