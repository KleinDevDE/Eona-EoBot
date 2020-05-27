package de.eonadev.discord.eobot.api.events.discord.role;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.role.RoleChangeNameEvent;


public class RoleNameChangedEvent extends Event {
    private String newName;
    private String oldName;
    private DiscordApi api;
    private Role role;
    private Server server;

    public RoleNameChangedEvent(RoleChangeNameEvent e){
        newName = e.getNewName();
        oldName = e.getOldName();
        role = e.getRole();
        api = e.getApi();
        server = e.getServer();
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

    public String getNewName() {
        return newName;
    }

    public String getOldName() {
        return oldName;
    }
}
