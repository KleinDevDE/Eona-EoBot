package de.eonadev.discord.eobot.api.listeners.discord.channel;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.group.GroupChannelDeletedEvent;
import org.javacord.api.event.channel.group.GroupChannelDeleteEvent;
import org.javacord.api.listener.channel.group.GroupChannelDeleteListener;

public class AGroupChannelDeleteListener implements GroupChannelDeleteListener {
    @Override
    public void onGroupChannelDelete(GroupChannelDeleteEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new GroupChannelDeletedEvent(e));
    }
}