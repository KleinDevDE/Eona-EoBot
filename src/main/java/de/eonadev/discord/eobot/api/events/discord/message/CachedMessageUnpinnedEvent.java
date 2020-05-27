package de.eonadev.discord.eobot.api.events.discord.message;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.GroupChannel;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAttachment;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.Reaction;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.CachedMessageUnpinEvent;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


public class CachedMessageUnpinnedEvent extends Event {
    private DiscordApi api;
    private TextChannel textChannel;
    private User user;
    private Emoji emoji;
    private CompletableFuture<List<User>> users;
    private Optional<Reaction> reaction;
    private Message message;
    private long messageID;
    private List<MessageAttachment> messageAttachments;
    private String messageContent;
    private String readableMessageContent;
    private MessageAuthor messageAuthor;
    private Optional<Integer> count;
    private Optional<Server> server;
    private Optional<GroupChannel> groupChannel;
    private Optional<PrivateChannel> privateChannel;
    private Optional<ServerTextChannel> serverTextChannel;

    public CachedMessageUnpinnedEvent(CachedMessageUnpinEvent e) {
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

    public CompletableFuture<List<User>> getUsers() {
        return users;
    }

    public User getUser() {
        return user;
    }

    public Emoji getEmoji() {
        return emoji;
    }

    public long getMessageID() {
        return messageID;
    }

    public Optional<Integer> getCount() {
        return count;
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

    public Optional<Reaction> getReaction() {
        return reaction;
    }

    public Optional<Server> getServer() {
        return server;
    }

    public List<MessageAttachment> getMessageAttachments() {
        return messageAttachments;
    }

    public Message getMessage() {
        return message;
    }

    public MessageAuthor getMessageAuthor() {
        return messageAuthor;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getReadableMessageContent() {
        return readableMessageContent;
    }
}
