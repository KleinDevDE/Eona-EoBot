package de.eonadev.discord.eobot.api.events.discord.channels.group;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.GroupChannel;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.event.channel.group.GroupChannelDeleteEvent;

import java.util.Optional;


public class GroupChannelDeletedEvent extends Event {
    private DiscordApi api;
    private TextChannel textChannel;
    private Optional<GroupChannel> groupChannel;
    private Optional<PrivateChannel> privateChannel;
    private Optional<ServerTextChannel> serverTextChannel;

    public GroupChannelDeletedEvent(GroupChannelDeleteEvent e){
        api = e.getApi();
        textChannel = e.getChannel();
        groupChannel = e.getGroupChannel();
        privateChannel = e.getPrivateChannel();
        serverTextChannel = e.getServerTextChannel();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Optional<GroupChannel> getGroupChannel() {
        return groupChannel;
    }

    public Optional<PrivateChannel> getPrivateChannel() {
        return privateChannel;
    }

    public Optional<ServerTextChannel> getServerTextChannel() {
        return serverTextChannel;
    }

    public TextChannel getTextChannel() {
        return textChannel;
    }
}
