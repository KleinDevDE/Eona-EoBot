package de.eonadev.discord.eobot.api.events.discord.role;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.role.RoleChangeHoistEvent;


public class RoleHoistChangedEvent extends Event {
    private boolean newHoist;
    private boolean oldHoist;
    private DiscordApi api;
    private Role role;
    private Server server;

    public RoleHoistChangedEvent(RoleChangeHoistEvent e){
        newHoist = e.getNewHoist();
        oldHoist = e.getOldHoist();
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

    public boolean getNewHoist() {
        return newHoist;
    }

    public boolean getOldHoist() {
        return oldHoist;
    }
}
