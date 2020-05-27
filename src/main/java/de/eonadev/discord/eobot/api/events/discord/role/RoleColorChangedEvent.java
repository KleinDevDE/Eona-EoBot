package de.eonadev.discord.eobot.api.events.discord.role;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.role.RoleChangeColorEvent;

import java.awt.*;
import java.util.Optional;


public class RoleColorChangedEvent extends Event {
    private Optional<Color> oldColor;
    private Optional<Color> newColor;
    private DiscordApi api;
    private Server server;
    private Role role;

    public RoleColorChangedEvent(RoleChangeColorEvent e){
        oldColor = e.getOldColor();
        newColor = e.getNewColor();
        api = e.getApi();
        server = e.getServer();
        role = e.getRole();
    }

    public Role getRole() {
        return role;
    }

    public Server getServer() {
        return server;
    }

    public DiscordApi getApi() {
        return api;
    }

    public Optional<Color> getNewColor() {
        return newColor;
    }

    public Optional<Color> getOldColor() {
        return oldColor;
    }
}
