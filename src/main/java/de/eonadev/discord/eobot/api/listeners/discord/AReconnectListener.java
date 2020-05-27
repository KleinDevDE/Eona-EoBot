package de.eonadev.discord.eobot.api.listeners.discord;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.DiscordReconnectEvent;
import org.javacord.api.event.connection.ReconnectEvent;
import org.javacord.api.listener.connection.ReconnectListener;

public class AReconnectListener implements ReconnectListener {
    @Override
    public void onReconnect(ReconnectEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new DiscordReconnectEvent());
    }
}