package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerAFKChannelChangedEvent;
import org.javacord.api.event.server.ServerChangeAfkChannelEvent;
import org.javacord.api.listener.server.ServerChangeAfkChannelListener;

public class AServerChangeAfkChannelListener implements ServerChangeAfkChannelListener {
    @Override
    public void onServerChangeAfkChannel(ServerChangeAfkChannelEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerAFKChannelChangedEvent(e));
    }
}