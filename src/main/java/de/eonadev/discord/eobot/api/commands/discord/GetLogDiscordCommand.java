package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import de.eonadev.discord.eobot.utils.logging.Logger;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

@CommandInfo(cmd = "getlog", permission = "eobot.debug.getlog", description = "Shows the last 20 log messages")
public class GetLogDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        StringBuilder sb = new StringBuilder();
        for(String s : Logger.getLastLogs()){
            sb.append(s).append("\n");
        }
        Response response = new Response(message);
        response.setTitle("Last 20 log messages").setDeletionTime(-1L).setText("```" + sb.toString() + "```").send(true);
    }
}
