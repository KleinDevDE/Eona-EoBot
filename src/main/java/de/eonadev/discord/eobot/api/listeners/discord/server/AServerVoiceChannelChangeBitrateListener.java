package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.voice.VoiceChannelBitrateChangedEvent;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelChangeBitrateEvent;
import org.javacord.api.listener.channel.server.voice.ServerVoiceChannelChangeBitrateListener;

public class AServerVoiceChannelChangeBitrateListener implements ServerVoiceChannelChangeBitrateListener {
    @Override
    public void onServerVoiceChannelChangeBitrate(ServerVoiceChannelChangeBitrateEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new VoiceChannelBitrateChangedEvent(e));
    }
}