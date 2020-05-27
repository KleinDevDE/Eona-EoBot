package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.Region;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerChangeRegionEvent;


public class ServerRegionChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private Region oldRegion;
    private Region newRegion;

    public ServerRegionChangedEvent(ServerChangeRegionEvent e){
        api = e.getApi();
        server = e.getServer();
        oldRegion = e.getOldRegion();
        newRegion = e.getNewRegion();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public Region getNewRegion() {
        return newRegion;
    }

    public Region getOldRegion() {
        return oldRegion;
    }
}
