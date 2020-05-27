package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.channels.serverchannel.ServerChannelDeletedEvent;
import org.javacord.api.event.channel.server.ServerChannelDeleteEvent;
import org.javacord.api.listener.channel.server.ServerChannelDeleteListener;

public class AServerChannelDeleteListener implements ServerChannelDeleteListener {
    @Override
    public void onServerChannelDelete(ServerChannelDeleteEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerChannelDeletedEvent(e));
    }
}