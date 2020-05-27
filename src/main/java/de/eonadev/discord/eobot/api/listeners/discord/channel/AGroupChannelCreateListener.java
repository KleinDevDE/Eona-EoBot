package de.eonadev.discord.eobot.api.listeners.discord.channel;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.group.GroupChannelCreatedEvent;
import org.javacord.api.event.channel.group.GroupChannelCreateEvent;
import org.javacord.api.listener.channel.group.GroupChannelCreateListener;

public class AGroupChannelCreateListener implements GroupChannelCreateListener {
    @Override
    public void onGroupChannelCreate(GroupChannelCreateEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new GroupChannelCreatedEvent(e));
    }
}