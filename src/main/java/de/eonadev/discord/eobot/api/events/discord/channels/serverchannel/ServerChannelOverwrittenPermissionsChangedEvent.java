package de.eonadev.discord.eobot.api.events.discord.channels.serverchannel;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.DiscordEntity;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.channel.server.ServerChannelChangeOverwrittenPermissionsEvent;

import java.util.Optional;


public class ServerChannelOverwrittenPermissionsChangedEvent extends Event {
    private DiscordApi api;
    private ServerChannel serverChannel;
    private Server server;
    private Permissions oldPermissions;
    private Permissions newPermissions;
    private Optional<Role> role;
    private Optional<User> user;
    private DiscordEntity entity;

    public ServerChannelOverwrittenPermissionsChangedEvent(ServerChannelChangeOverwrittenPermissionsEvent e){
        api = e.getApi();
        serverChannel = e.getChannel();
        server = e.getServer();
        oldPermissions = e.getOldPermissions();
        newPermissions = e.getNewPermissions();
        role = e.getRole();
        user = e.getUser();
        entity = e.getEntity();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public ServerChannel getServerChannel() {
        return serverChannel;
    }

    public Optional<Role> getRole() {
        return role;
    }

    public Optional<User> getUser() {
        return user;
    }

    public Permissions getNewPermissions() {
        return newPermissions;
    }

    public Permissions getOldPermissions() {
        return oldPermissions;
    }

    public DiscordEntity getEntity() {
        return entity;
    }
}
