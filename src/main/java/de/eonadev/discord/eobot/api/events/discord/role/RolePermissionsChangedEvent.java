package de.eonadev.discord.eobot.api.events.discord.role;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.role.RoleChangePermissionsEvent;


public class RolePermissionsChangedEvent extends Event {
    private Permissions newPermissions;
    private Permissions oldPermissions;
    private DiscordApi api;
    private Role role;
    private Server server;

    public RolePermissionsChangedEvent(RoleChangePermissionsEvent e){
        newPermissions = e.getNewPermissions();
        oldPermissions = e.getOldPermissions();
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

    public Permissions getOldPermissions() {
        return oldPermissions;
    }

    public Permissions getNewPermissions() {
        return newPermissions;
    }
}
