package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

@CommandInfo(cmd = "reload", permission = "eobot.system.reload", description = "Reload eobot and plugins configuration")
public class ReloadDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        Response response = new Response(message);
        response.setText("Configs reloaded");
        response.setDeletionTime(5);
        EoBot.getInstance().getEoBotConfiguration().reload();
        for (String plugin : EoBot.getInstance().getPluginManager().getActivePlugins()) {
            EoBot.getInstance().getPluginManager().getPlugin(plugin).reload();
        }
        response.send(true);
    }
}
