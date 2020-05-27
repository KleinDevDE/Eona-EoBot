package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerChangeAfkTimeoutEvent;


public class ServerAFKTimeoutChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private int newAfkTimeoutInSeconds;
    private int oldAfkTimeoutInSeconds;

    public ServerAFKTimeoutChangedEvent(ServerChangeAfkTimeoutEvent e){
        api = e.getApi();
        server = e.getServer();
        oldAfkTimeoutInSeconds = e.getOldAfkTimeoutInSeconds();
        newAfkTimeoutInSeconds = e.getNewAfkTimeoutInSeconds();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public int getNewAfkTimeoutInSeconds() {
        return newAfkTimeoutInSeconds;
    }

    public int getOldAfkTimeoutInSeconds() {
        return oldAfkTimeoutInSeconds;
    }
}
