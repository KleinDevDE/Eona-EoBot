package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.voice.VoiceChannelUserLimitChangedEvent;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelChangeUserLimitEvent;
import org.javacord.api.listener.channel.server.voice.ServerVoiceChannelChangeUserLimitListener;

public class AServerVoiceChannelChangeUserLimitListener implements ServerVoiceChannelChangeUserLimitListener {
    @Override
    public void onServerVoiceChannelChangeUserLimit(ServerVoiceChannelChangeUserLimitEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new VoiceChannelUserLimitChangedEvent(e));
    }
}