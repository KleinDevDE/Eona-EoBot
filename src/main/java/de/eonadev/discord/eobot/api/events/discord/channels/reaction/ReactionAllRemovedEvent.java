package de.eonadev.discord.eobot.api.events.discord.channels.reaction;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.GroupChannel;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAttachment;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.message.reaction.ReactionRemoveAllEvent;

import java.util.List;
import java.util.Optional;


public class ReactionAllRemovedEvent extends Event {
    private DiscordApi api;
    private TextChannel textChannel;
    private Optional<Message> message;
    private long messageID;
    private Optional<List<MessageAttachment>> messageAttachments;
    private Optional<String> messageContent;
    private Optional<String> readableMessageContent;
    private Optional<MessageAuthor> messageAuthor;
    private Optional<Server> server;
    private Optional<GroupChannel> groupChannel;
    private Optional<PrivateChannel> privateChannel;
    private Optional<ServerTextChannel> serverTextChannel;

    public ReactionAllRemovedEvent(ReactionRemoveAllEvent e) {
        api = e.getApi();
        textChannel = e.getChannel();
        message = e.getMessage();
        messageID = e.getMessageId();
        messageAttachments = e.getMessageAttachments();
        messageContent = e.getMessageContent();
        readableMessageContent = e.getReadableMessageContent();
        messageAuthor = e.getMessageAuthor();
        server = e.getServer();
        groupChannel = e.getGroupChannel();
        privateChannel = e.getPrivateChannel();
        serverTextChannel = e.getServerTextChannel();
    }

    public DiscordApi getApi() {
        return api;
    }

    public TextChannel getTextChannel() {
        return textChannel;
    }

    public long getMessageID() {
        return messageID;
    }

    public Optional<ServerTextChannel> getServerTextChannel() {
        return serverTextChannel;
    }

    public Optional<PrivateChannel> getPrivateChannel() {
        return privateChannel;
    }

    public Optional<GroupChannel> getGroupChannel() {
        return groupChannel;
    }

    public Optional<List<MessageAttachment>> getMessageAttachments() {
        return messageAttachments;
    }

    public Optional<Message> getMessage() {
        return message;
    }

    public Optional<MessageAuthor> getMessageAuthor() {
        return messageAuthor;
    }

    public Optional<Server> getServer() {
        return server;
    }

    public Optional<String> getMessageContent() {
        return messageContent;
    }

    public Optional<String> getReadableMessageContent() {
        return readableMessageContent;
    }
}
