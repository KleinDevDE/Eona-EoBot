package de.eonadev.discord.eobot.api.listeners.discord.channel;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.group.GroupChannelNameChangedEvent;
import org.javacord.api.event.channel.group.GroupChannelChangeNameEvent;
import org.javacord.api.listener.channel.group.GroupChannelChangeNameListener;

public class AGroupChannelChangeNameListener implements GroupChannelChangeNameListener {
    @Override
    public void onGroupChannelChangeName(GroupChannelChangeNameEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new GroupChannelNameChangedEvent(e));
    }
}