package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

@CommandInfo(cmd = "help", description = "Shows an generated help page from all registered commands")
public class HelpDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        //TODO permission check
        Response response = new Response(message);
        Response.EmbedListBuilder embedListBuilder = response.getEmbedListBuilder("command", "description");
        for (Command cmd : EoBot.getInstance().getPluginManager().getAllDiscordCommands()) {
            CommandInfo info = cmd.getClass().getAnnotation(CommandInfo.class);
            embedListBuilder.addLine(info.cmd(), info.description());
        }
        response = embedListBuilder.build();
        response.setDeletionTime(-1L);
        response.send(false);
    }
}
