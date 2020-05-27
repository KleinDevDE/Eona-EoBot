package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerVerificationLevelChangedEvent;
import org.javacord.api.event.server.ServerChangeVerificationLevelEvent;
import org.javacord.api.listener.server.ServerChangeVerificationLevelListener;

public class AServerChangeVerificationLevelListener implements ServerChangeVerificationLevelListener {
    @Override
    public void onServerChangeVerificationLevel(ServerChangeVerificationLevelEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerVerificationLevelChangedEvent(e));
    }
}