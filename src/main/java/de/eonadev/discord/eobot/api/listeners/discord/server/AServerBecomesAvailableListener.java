package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import org.javacord.api.event.server.ServerBecomesAvailableEvent;
import org.javacord.api.listener.server.ServerBecomesAvailableListener;

public class AServerBecomesAvailableListener implements ServerBecomesAvailableListener {
    @Override
    public void onServerBecomesAvailable(ServerBecomesAvailableEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new de.eonadev.discord.eobot.api.events.discord.server.ServerBecomesAvailableEvent(e));
    }
}