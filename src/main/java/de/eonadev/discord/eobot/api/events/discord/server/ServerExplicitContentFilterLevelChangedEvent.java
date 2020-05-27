package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.ExplicitContentFilterLevel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerChangeExplicitContentFilterLevelEvent;


public class ServerExplicitContentFilterLevelChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private ExplicitContentFilterLevel oldExplicitContentFilterLevel;
    private ExplicitContentFilterLevel newExplicitContentFilterLevel;

    public ServerExplicitContentFilterLevelChangedEvent(ServerChangeExplicitContentFilterLevelEvent e){
        api = e.getApi();
        server = e.getServer();
        oldExplicitContentFilterLevel = e.getOldExplicitContentFilterLevel();
        newExplicitContentFilterLevel = e.getNewExplicitContentFilterLevel();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public ExplicitContentFilterLevel getNewExplicitContentFilterLevel() {
        return newExplicitContentFilterLevel;
    }

    public ExplicitContentFilterLevel getOldExplicitContentFilterLevel() {
        return oldExplicitContentFilterLevel;
    }
}
