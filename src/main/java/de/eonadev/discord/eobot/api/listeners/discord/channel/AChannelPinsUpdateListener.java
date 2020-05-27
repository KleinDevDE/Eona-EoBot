package de.eonadev.discord.eobot.api.listeners.discord.channel;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.ChannelPinsUpdatedEvent;
import org.javacord.api.event.message.ChannelPinsUpdateEvent;
import org.javacord.api.listener.message.ChannelPinsUpdateListener;

public class AChannelPinsUpdateListener implements ChannelPinsUpdateListener {
    @Override
    public void onChannelPinsUpdate(ChannelPinsUpdateEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ChannelPinsUpdatedEvent(e));
    }
}