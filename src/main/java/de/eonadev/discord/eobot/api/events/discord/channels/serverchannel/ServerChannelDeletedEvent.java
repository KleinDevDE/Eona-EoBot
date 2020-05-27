package de.eonadev.discord.eobot.api.events.discord.channels.serverchannel;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.channel.server.ServerChannelDeleteEvent;


public class ServerChannelDeletedEvent extends Event {
    private DiscordApi api;
    private ServerChannel serverChannel;
    private Server server;

    public ServerChannelDeletedEvent(ServerChannelDeleteEvent e){
        api = e.getApi();
        serverChannel = e.getChannel();
        server = e.getServer();
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
}
