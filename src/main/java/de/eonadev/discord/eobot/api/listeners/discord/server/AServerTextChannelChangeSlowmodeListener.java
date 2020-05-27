package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.ServerTextChannelSlowmodeChangedEvent;
import org.javacord.api.event.channel.server.text.ServerTextChannelChangeSlowmodeEvent;
import org.javacord.api.listener.channel.server.text.ServerTextChannelChangeSlowmodeListener;

public class AServerTextChannelChangeSlowmodeListener implements ServerTextChannelChangeSlowmodeListener {
    @Override
    public void onServerTextChannelChangeSlowmodeDelay(ServerTextChannelChangeSlowmodeEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerTextChannelSlowmodeChangedEvent(e));
    }
}