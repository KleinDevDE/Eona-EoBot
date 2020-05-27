package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.ServerTextChannelTopicChangedEvent;
import org.javacord.api.event.channel.server.text.ServerTextChannelChangeTopicEvent;
import org.javacord.api.listener.channel.server.text.ServerTextChannelChangeTopicListener;

public class AServerTextChannelChangeTopicListener implements ServerTextChannelChangeTopicListener {
    @Override
    public void onServerTextChannelChangeTopic(ServerTextChannelChangeTopicEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerTextChannelTopicChangedEvent(e));
    }
}