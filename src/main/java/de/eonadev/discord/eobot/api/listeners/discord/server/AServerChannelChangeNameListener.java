package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.channels.serverchannel.ServerChannelNameChangedEvent;
import org.javacord.api.event.channel.server.ServerChannelChangeNameEvent;
import org.javacord.api.listener.channel.server.ServerChannelChangeNameListener;

public class AServerChannelChangeNameListener implements ServerChannelChangeNameListener {
    @Override
    public void onServerChannelChangeName(ServerChannelChangeNameEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerChannelNameChangedEvent(e));
    }
}