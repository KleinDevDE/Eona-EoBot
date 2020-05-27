package de.eonadev.discord.eobot.api.listeners.discord.channel;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.privatechannel.PrivateChannelCreatedEvent;
import org.javacord.api.event.channel.user.PrivateChannelCreateEvent;
import org.javacord.api.listener.channel.user.PrivateChannelCreateListener;

public class APrivateChannelCreateListener implements PrivateChannelCreateListener {
    @Override
    public void onPrivateChannelCreate(PrivateChannelCreateEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new PrivateChannelCreatedEvent(e));
    }
}