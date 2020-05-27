package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerChangeSystemChannelEvent;

import java.util.Optional;


public class ServerSystemChannelChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private Optional<ServerTextChannel> oldSystemChannel;
    private Optional<ServerTextChannel> newSystemChannel;


    public ServerSystemChannelChangedEvent(ServerChangeSystemChannelEvent e){
        api = e.getApi();
        server = e.getServer();
        oldSystemChannel = e.getOldSystemChannel();
        newSystemChannel = e.getNewSystemChannel();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public Optional<ServerTextChannel> getNewSystemChannel() {
        return newSystemChannel;
    }

    public Optional<ServerTextChannel> getOldSystemChannel() {
        return oldSystemChannel;
    }
}
