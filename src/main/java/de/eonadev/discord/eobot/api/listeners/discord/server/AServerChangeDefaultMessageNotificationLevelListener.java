package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerDefaultMessageNotificationLevelChangedEvent;
import org.javacord.api.event.server.ServerChangeDefaultMessageNotificationLevelEvent;
import org.javacord.api.listener.server.ServerChangeDefaultMessageNotificationLevelListener;

public class AServerChangeDefaultMessageNotificationLevelListener implements ServerChangeDefaultMessageNotificationLevelListener {
    @Override
    public void onServerChangeDefaultMessageNotificationLevel(ServerChangeDefaultMessageNotificationLevelEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerDefaultMessageNotificationLevelChangedEvent(e));
    }
}