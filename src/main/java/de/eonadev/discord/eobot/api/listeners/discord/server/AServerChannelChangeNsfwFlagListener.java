package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.channels.serverchannel.ServerChannelNSFWFlagChangedEvent;
import org.javacord.api.event.channel.server.ServerChannelChangeNsfwFlagEvent;
import org.javacord.api.listener.channel.server.ServerChannelChangeNsfwFlagListener;

public class AServerChannelChangeNsfwFlagListener implements ServerChannelChangeNsfwFlagListener {
    @Override
    public void onServerChannelChangeNsfwFlag(ServerChannelChangeNsfwFlagEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerChannelNSFWFlagChangedEvent(e));
    }
}