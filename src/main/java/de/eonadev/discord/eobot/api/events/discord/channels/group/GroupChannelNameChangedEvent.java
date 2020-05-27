package de.eonadev.discord.eobot.api.events.discord.channels.group;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.GroupChannel;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.event.channel.group.GroupChannelChangeNameEvent;

import java.util.Optional;


public class GroupChannelNameChangedEvent extends Event {
    String newName;
    String oldName;
    DiscordApi api;
    private TextChannel textChannel;
    private Optional<GroupChannel> groupChannel;
    private Optional<PrivateChannel> privateChannel;
    private Optional<ServerTextChannel> serverTextChannel;

    public GroupChannelNameChangedEvent(GroupChannelChangeNameEvent e){
        api = e.getApi();
        oldName = e.getOldName();
        newName = e.getNewName();
        textChannel = e.getChannel();
        groupChannel = e.getGroupChannel();
        privateChannel = e.getPrivateChannel();
        serverTextChannel = e.getServerTextChannel();
    }

    public TextChannel getTextChannel() {
        return textChannel;
    }

    public Optional<ServerTextChannel> getServerTextChannel() {
        return serverTextChannel;
    }

    public Optional<PrivateChannel> getPrivateChannel() {
        return privateChannel;
    }

    public Optional<GroupChannel> getGroupChannel() {
        return groupChannel;
    }

    public DiscordApi getApi() {
        return api;
    }

    public String getNewName() {
        return newName;
    }

    public String getOldName() {
        return oldName;
    }
}
