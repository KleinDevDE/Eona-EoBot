package de.eonadev.discord.eobot.api.events.discord.role;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.role.RoleChangePositionEvent;


public class RolePositionChangedEvent extends Event {
    private DiscordApi api;
    private Role role;
    private Server server;
    private int oldPosition;
    private int newPosition;

    public RolePositionChangedEvent(RoleChangePositionEvent e){
        api = e.getApi();
        role = e.getRole();
        oldPosition = e.getOldPosition();
        newPosition = e.getNewPosition();
        server = e.getServer();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public int getOldPosition() {
        return oldPosition;
    }

    public int getNewPosition() {
        return newPosition;
    }

    public Role getRole() {
        return role;
    }
}
