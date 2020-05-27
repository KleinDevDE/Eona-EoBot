package de.eonadev.discord.eobot.api.events.discord.server;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.DefaultMessageNotificationLevel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerChangeDefaultMessageNotificationLevelEvent;


public class ServerDefaultMessageNotificationLevelChangedEvent extends Event {
    private DiscordApi api;
    private Server server;
    private DefaultMessageNotificationLevel oldDefaultMessageNotificationLevel;
    private DefaultMessageNotificationLevel newDefaultMessageNotificationLevel;

    public ServerDefaultMessageNotificationLevelChangedEvent(ServerChangeDefaultMessageNotificationLevelEvent e){
        api = e.getApi();
        server = e.getServer();
        oldDefaultMessageNotificationLevel = e.getOldDefaultMessageNotificationLevel();
        newDefaultMessageNotificationLevel = e.getNewDefaultMessageNotificationLevel();
    }

    public Server getServer() {
        return server;
    }

    public DiscordApi getApi() {
        return api;
    }

    public DefaultMessageNotificationLevel getNewDefaultMessageNotificationLevel() {
        return newDefaultMessageNotificationLevel;
    }

    public DefaultMessageNotificationLevel getOldDefaultMessageNotificationLevel() {
        return oldDefaultMessageNotificationLevel;
    }
}
