package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.Icon;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerChangeIconEvent;

import java.util.Optional;


public class ServerIconChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private Optional<Icon> oldIcon;
    private Optional<Icon> newIcon;

    public ServerIconChangedEvent(ServerChangeIconEvent e){
        api = e.getApi();
        server = e.getServer();
        oldIcon = e.getOldIcon();
        newIcon = e.getNewIcon();
    }

    public Server getServer() {
        return server;
    }

    public DiscordApi getApi() {
        return api;
    }

    public Optional<Icon> getNewIcon() {
        return newIcon;
    }

    public Optional<Icon> getOldIcon() {
        return oldIcon;
    }
}
