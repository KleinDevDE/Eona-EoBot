package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.GroupChannel;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.channel.server.text.ServerTextChannelChangeTopicEvent;

import java.util.Optional;


public class ServerTextChannelTopicChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private Channel channel;
    private Optional<PrivateChannel> privateChannel;
    private Optional<ServerTextChannel> serverTextChannel;
    private Optional<GroupChannel> groupChannel;
    private String oldTopic;
    private String newTopic;


    public ServerTextChannelTopicChangedEvent(ServerTextChannelChangeTopicEvent e){
        api = e.getApi();
        server = e.getServer();
        channel = e.getChannel();
        privateChannel = e.getPrivateChannel();
        serverTextChannel = e.getServerTextChannel();
        groupChannel = e.getGroupChannel();
        oldTopic = e.getOldTopic();
        newTopic = e.getNewTopic();
    }

    public Server getServer() {
        return server;
    }

    public DiscordApi getApi() {
        return api;
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

    public Channel getChannel() {
        return channel;
    }

    public String getNewTopic() {
        return newTopic;
    }

    public String getOldTopic() {
        return oldTopic;
    }
}
