package de.eonadev.discord.eobot.api.listeners.discord.channel;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.privatechannel.PrivateChannelDeletedEvent;
import org.javacord.api.event.channel.user.PrivateChannelDeleteEvent;
import org.javacord.api.listener.channel.user.PrivateChannelDeleteListener;

public class APrivateChannelDeleteListener implements PrivateChannelDeleteListener {
    @Override
    public void onPrivateChannelDelete(PrivateChannelDeleteEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new PrivateChannelDeletedEvent(e));
    }
}