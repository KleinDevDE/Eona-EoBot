package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.utils.handlers.ExceptionHandler;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

@CommandInfo(cmd = "throwexception", permission = "eobot.debug.throwexception", description = "This will throw an Exception")
public class ThrowExceptionDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        ExceptionHandler.handle(new Exception("Triggerd by !throwexception"));
    }
}
