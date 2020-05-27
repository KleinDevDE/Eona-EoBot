package de.eonadev.discord.eobot.api.events.discord.channels.serverchannel;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.channel.server.ServerChannelChangeNsfwFlagEvent;


public class ServerChannelNSFWFlagChangedEvent extends Event {
    private DiscordApi api;
    private ServerChannel serverChannel;
    private Server server;
    private boolean oldNSFWFlag;
    private boolean newNSFWFlag;

    public ServerChannelNSFWFlagChangedEvent(ServerChannelChangeNsfwFlagEvent e){
        api = e.getApi();
        serverChannel = e.getChannel();
        server = e.getServer();
        oldNSFWFlag = e.getOldNsfwFlag();
        newNSFWFlag = e.getNewNsfwFlag();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public ServerChannel getServerChannel() {
        return serverChannel;
    }

    public boolean getNewNSFWFlag() {
        return newNSFWFlag;
    }

    public boolean getOldNSFWFlag() {
        return oldNSFWFlag;
    }
}
