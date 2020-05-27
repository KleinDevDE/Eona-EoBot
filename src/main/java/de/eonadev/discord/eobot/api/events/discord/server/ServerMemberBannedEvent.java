package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Ban;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberBanEvent;

import java.util.Optional;


public class ServerMemberBannedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private User bannedUser;
    ServerMemberBanEvent e;

    public ServerMemberBannedEvent(ServerMemberBanEvent e){
        this.e = e;
        api = e.getApi();
        server = e.getServer();
        bannedUser = e.getUser();
    }

    public Server getServer() {
        return server;
    }

    public DiscordApi getApi() {
        return api;
    }

    public User getBannedUser() {
        return bannedUser;
    }

    public Optional<Ban> getBan(){
        return e.requestBan().join();
    }

    public Optional<String> getReason(){
        return e.requestReason().join();
    }
}
