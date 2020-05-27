package de.eonadev.discord.eobot.api.commands.base;

import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

public abstract class Command {
    public abstract void run(Message message, ChannelType channelType, String messageContent, String[] args);
}
