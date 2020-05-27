package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerMultiFactorAuthenticationLevelChangedEvent;
import org.javacord.api.event.server.ServerChangeMultiFactorAuthenticationLevelEvent;
import org.javacord.api.listener.server.ServerChangeMultiFactorAuthenticationLevelListener;

public class AServerChangeMultiFactorAuthenticationLevelListener implements ServerChangeMultiFactorAuthenticationLevelListener {
    @Override
    public void onServerChangeMultiFactorAuthenticationLevel(ServerChangeMultiFactorAuthenticationLevelEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerMultiFactorAuthenticationLevelChangedEvent(e));
    }
}