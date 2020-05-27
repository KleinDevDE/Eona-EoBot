package de.eonadev.discord.eobot.api.listeners.discord;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.DiscordConnectionLostEvent;
import org.javacord.api.event.connection.LostConnectionEvent;
import org.javacord.api.listener.connection.LostConnectionListener;

public class ALostConnectionListener implements LostConnectionListener {
    @Override
    public void onLostConnection(LostConnectionEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new DiscordConnectionLostEvent());
    }
}