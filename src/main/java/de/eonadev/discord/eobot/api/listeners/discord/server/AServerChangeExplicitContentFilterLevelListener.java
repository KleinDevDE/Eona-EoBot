package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerExplicitContentFilterLevelChangedEvent;
import org.javacord.api.event.server.ServerChangeExplicitContentFilterLevelEvent;
import org.javacord.api.listener.server.ServerChangeExplicitContentFilterLevelListener;

public class AServerChangeExplicitContentFilterLevelListener implements ServerChangeExplicitContentFilterLevelListener {
    @Override
    public void onServerChangeExplicitContentFilterLevel(ServerChangeExplicitContentFilterLevelEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerExplicitContentFilterLevelChangedEvent(e));
    }
}