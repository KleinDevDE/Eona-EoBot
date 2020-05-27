package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import org.javacord.api.event.server.ServerBecomesUnavailableEvent;
import org.javacord.api.listener.server.ServerBecomesUnavailableListener;

public class AServerBecomesUnavailableListener implements ServerBecomesUnavailableListener {
    @Override
    public void onServerBecomesUnavailable(ServerBecomesUnavailableEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new de.eonadev.discord.eobot.api.events.discord.server.ServerBecomesUnavailableEvent(e));
    }
}