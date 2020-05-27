package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.server.VerificationLevel;
import org.javacord.api.event.server.ServerChangeVerificationLevelEvent;


public class ServerVerificationLevelChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private VerificationLevel oldVerificationLevel;
    private VerificationLevel newVerificationLevel;

    public ServerVerificationLevelChangedEvent(ServerChangeVerificationLevelEvent e){
        api = e.getApi();
        server = e.getServer();
        oldVerificationLevel = e.getOldVerificationLevel();
        newVerificationLevel = e.getNewVerificationLevel();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public VerificationLevel getNewVerificationLevel() {
        return newVerificationLevel;
    }

    public VerificationLevel getOldVerificationLevel() {
        return oldVerificationLevel;
    }
}
