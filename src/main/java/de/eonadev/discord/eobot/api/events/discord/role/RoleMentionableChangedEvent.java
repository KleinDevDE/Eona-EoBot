package de.eonadev.discord.eobot.api.events.discord.role;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.role.RoleChangeMentionableEvent;


public class RoleMentionableChangedEvent extends Event {
    private boolean newMentionableFlag;
    private boolean oldMentionableFlag;
    private DiscordApi api;
    private Role role;
    private Server server;

    public RoleMentionableChangedEvent(RoleChangeMentionableEvent e){
        newMentionableFlag = e.getNewMentionableFlag();
        oldMentionableFlag = e.getOldMentionableFlag();
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

    public boolean getNewMentionableFlag() {
        return newMentionableFlag;
    }

    public boolean getOldMentionableFlag() {
        return oldMentionableFlag;
    }
}
