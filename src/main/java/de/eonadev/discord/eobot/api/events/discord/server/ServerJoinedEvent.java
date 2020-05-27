package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerJoinEvent;

// TODO Disallow all servers except Eona
public class ServerJoinedEvent extends Event {
    private DiscordApi api;
    private Server server;

    public ServerJoinedEvent(ServerJoinEvent e){
        api = e.getApi();
        server = e.getServer();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }
}
