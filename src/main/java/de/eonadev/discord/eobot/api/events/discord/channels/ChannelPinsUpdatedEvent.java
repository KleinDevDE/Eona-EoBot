package de.eonadev.discord.eobot.api.events.discord.channels;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.GroupChannel;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.event.message.ChannelPinsUpdateEvent;

import java.time.Instant;
import java.util.Optional;


public class ChannelPinsUpdatedEvent extends Event {
    private Optional<Instant> lastPinTimestamp;
    private DiscordApi api;
    private TextChannel textChannel;
    private Optional<GroupChannel> groupChannel;
    private Optional<PrivateChannel> privateChannel;
    private Optional<ServerTextChannel> serverTextChannel;

    public ChannelPinsUpdatedEvent(ChannelPinsUpdateEvent e){
        lastPinTimestamp = e.getLastPinTimestamp();
        api = e.getApi();
        textChannel = e.getChannel();
        groupChannel = e.getGroupChannel();
        privateChannel = e.getPrivateChannel();
        serverTextChannel = e.getServerTextChannel();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Optional<GroupChannel> getGroupChannel() {
        return groupChannel;
    }

    public Optional<Instant> getLastPinTimestamp() {
        return lastPinTimestamp;
    }

    public Optional<PrivateChannel> getPrivateChannel() {
        return privateChannel;
    }

    public Optional<ServerTextChannel> getServerTextChannel() {
        return serverTextChannel;
    }

    public TextChannel getTextChannel() {
        return textChannel;
    }
}
