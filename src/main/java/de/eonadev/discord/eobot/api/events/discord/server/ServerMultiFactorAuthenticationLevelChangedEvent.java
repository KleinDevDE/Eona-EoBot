package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.MultiFactorAuthenticationLevel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerChangeMultiFactorAuthenticationLevelEvent;


public class ServerMultiFactorAuthenticationLevelChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private MultiFactorAuthenticationLevel oldMultiFactorAuthenticationLevel;
    private MultiFactorAuthenticationLevel newMultiFactorAuthenticationLevel;

    public ServerMultiFactorAuthenticationLevelChangedEvent(ServerChangeMultiFactorAuthenticationLevelEvent e){
        api = e.getApi();
        server = e.getServer();
        oldMultiFactorAuthenticationLevel = e.getOldMultiFactorAuthenticationLevel();
        newMultiFactorAuthenticationLevel = e.getNewMultiFactorAuthenticationLevel();
    }

    public Server getServer() {
        return server;
    }

    public DiscordApi getApi() {
        return api;
    }

    public MultiFactorAuthenticationLevel getNewMultiFactorAuthenticationLevel() {
        return newMultiFactorAuthenticationLevel;
    }

    public MultiFactorAuthenticationLevel getOldMultiFactorAuthenticationLevel() {
        return oldMultiFactorAuthenticationLevel;
    }
}
