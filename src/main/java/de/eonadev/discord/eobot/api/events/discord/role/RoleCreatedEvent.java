package de.eonadev.discord.eobot.api.events.discord.role;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.role.RoleCreateEvent;


public class RoleCreatedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private Role role;

    public RoleCreatedEvent(RoleCreateEvent e){
        api = e.getApi();
        server = e.getServer();
        role = e.getRole();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public Role getRole() {
        return role;
    }
}
