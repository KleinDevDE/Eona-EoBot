package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.channels.serverchannel.ServerChannelOverwrittenPermissionsChangedEvent;
import org.javacord.api.event.channel.server.ServerChannelChangeOverwrittenPermissionsEvent;
import org.javacord.api.listener.channel.server.ServerChannelChangeOverwrittenPermissionsListener;

public class AServerChannelChangeOverwrittenPermissionsListener implements ServerChannelChangeOverwrittenPermissionsListener {
    @Override
    public void onServerChannelChangeOverwrittenPermissions(ServerChannelChangeOverwrittenPermissionsEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerChannelOverwrittenPermissionsChangedEvent(e));
    }
}