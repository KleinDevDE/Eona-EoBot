package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.ServerChangeOwnerEvent;

//TODO Alert!!
public class ServerOwnerChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private User oldOwner;
    private User newOwner;

    public ServerOwnerChangedEvent(ServerChangeOwnerEvent e){
        api = e.getApi();
        server = e.getServer();
        oldOwner = e.getOldOwner();
        newOwner = e.getNewOwner();
    }

    public Server getServer() {
        return server;
    }

    public DiscordApi getApi() {
        return api;
    }

    public User getNewOwner() {
        return newOwner;
    }

    public User getOldOwner() {
        return oldOwner;
    }
}
