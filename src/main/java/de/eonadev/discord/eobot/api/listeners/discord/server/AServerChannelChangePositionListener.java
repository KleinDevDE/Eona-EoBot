package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.channels.serverchannel.ServerChannelPositionChangedEvent;
import org.javacord.api.event.channel.server.ServerChannelChangePositionEvent;
import org.javacord.api.listener.channel.server.ServerChannelChangePositionListener;

public class AServerChannelChangePositionListener implements ServerChannelChangePositionListener {
    @Override
    public void onServerChannelChangePosition(ServerChannelChangePositionEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerChannelPositionChangedEvent(e));
    }
}