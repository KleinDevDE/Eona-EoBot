package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerSystemChannelChangedEvent;
import org.javacord.api.event.server.ServerChangeSystemChannelEvent;
import org.javacord.api.listener.server.ServerChangeSystemChannelListener;

public class AServerChangeSystemChannelListener implements ServerChangeSystemChannelListener {
    @Override
    public void onServerChangeSystemChannel(ServerChangeSystemChannelEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerSystemChannelChangedEvent(e));
    }
}