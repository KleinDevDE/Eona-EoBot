package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerChangeAfkChannelEvent;

import java.util.Optional;


public class ServerAFKChannelChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private Optional<ServerVoiceChannel> oldAFKChannel;
    private Optional<ServerVoiceChannel> newAFKChannel;

    public ServerAFKChannelChangedEvent(ServerChangeAfkChannelEvent e){
        oldAFKChannel = e.getOldAfkChannel();
        newAFKChannel = e.getNewAfkChannel();
        api = e.getApi();
        server = e.getServer();
    }

    public Server getServer() {
        return server;
    }

    public DiscordApi getApi() {
        return api;
    }

    public Optional<ServerVoiceChannel> getNewAFKChannel() {
        return newAFKChannel;
    }

    public Optional<ServerVoiceChannel> getOldAFKChannel() {
        return oldAFKChannel;
    }
}
