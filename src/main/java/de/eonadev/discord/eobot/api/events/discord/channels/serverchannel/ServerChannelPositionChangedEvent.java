package de.eonadev.discord.eobot.api.events.discord.channels.serverchannel;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ChannelCategory;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.channel.server.ServerChannelChangePositionEvent;

import java.util.Optional;


public class ServerChannelPositionChangedEvent extends Event {
    private DiscordApi api;
    private ServerChannel serverChannel;
    private Server server;
    private Optional<ChannelCategory> oldCategory;
    private int oldPosition;
    private int oldRAWPosition;
    private Optional<ChannelCategory> newCategory;
    private int newPosition;
    private int newRAWPosition;

    public ServerChannelPositionChangedEvent(ServerChannelChangePositionEvent e){
        api = e.getApi();
        serverChannel = e.getChannel();
        server = e.getServer();
        oldCategory = e.getOldCategory();
        oldPosition = e.getOldPosition();
        oldRAWPosition = e.getOldRawPosition();
        newCategory = e.getNewCategory();
        newPosition = e.getNewPosition();
        newRAWPosition = e.getNewRawPosition();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public ServerChannel getServerChannel() {
        return serverChannel;
    }

    public int getNewPosition() {
        return newPosition;
    }

    public int getNewRAWPosition() {
        return newRAWPosition;
    }

    public int getOldPosition() {
        return oldPosition;
    }

    public int getOldRAWPosition() {
        return oldRAWPosition;
    }

    public Optional<ChannelCategory> getNewCategory() {
        return newCategory;
    }

    public Optional<ChannelCategory> getOldCategory() {
        return oldCategory;
    }
}
