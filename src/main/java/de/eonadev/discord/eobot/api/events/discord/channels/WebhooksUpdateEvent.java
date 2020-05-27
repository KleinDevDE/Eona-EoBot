package de.eonadev.discord.eobot.api.events.discord.channels;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.GroupChannel;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.server.Server;

import java.util.Optional;


public class WebhooksUpdateEvent extends Event {
    DiscordApi api;
    ServerTextChannel channel;
    Optional<ServerTextChannel> serverTextChannel;
    Optional<GroupChannel> groupChannel;
    Optional<PrivateChannel> privateChannel;
    Server server;

    public WebhooksUpdateEvent(org.javacord.api.event.channel.server.text.WebhooksUpdateEvent e){
        this.api = e.getApi();
        this.server = e.getServer();
        this.serverTextChannel = e.getServerTextChannel();
        groupChannel = e.getGroupChannel();
        privateChannel = e.getPrivateChannel();
        channel = e.getChannel();
    }

    public Server getServer() {
        return server;
    }

    public Optional<GroupChannel> getGroupChannel() {
        return groupChannel;
    }

    public Optional<PrivateChannel> getPrivateChannel() {
        return privateChannel;
    }

    public Optional<ServerTextChannel> getServerTextChannel() {
        return serverTextChannel;
    }

    public DiscordApi getApi() {
        return api;
    }

    public ServerTextChannel getChannel() {
        return channel;
    }
}
