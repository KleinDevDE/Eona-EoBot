package de.eonadev.discord.eobot.api.events.discord.channels.privatechannel;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.channel.user.PrivateChannelDeleteEvent;


public class PrivateChannelDeletedEvent extends Event {
    private DiscordApi api;
    private PrivateChannel privateChannel;
    private User user;

    public PrivateChannelDeletedEvent(PrivateChannelDeleteEvent e){
        api = e.getApi();
        user = e.getUser();
        privateChannel = e.getChannel();
    }

    public DiscordApi getApi() {
        return api;
    }

    public PrivateChannel getPrivateChannel() {
        return privateChannel;
    }

    public User getUser() {
        return user;
    }
}
