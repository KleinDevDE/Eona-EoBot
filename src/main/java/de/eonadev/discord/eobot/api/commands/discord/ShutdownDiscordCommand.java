package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

@CommandInfo(cmd = "stop", aliases = {"exit", "end", "poweroff", "shutdown"}, permission = "eobot.syste.shutdown", description = "Shutdown this eobot")
public class ShutdownDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        Response response = new Response(message);
        response.setText("Shutdown..");
        response.setDeletionTime(-1L);
        response.send(false);
        System.exit(0);
    }
}
