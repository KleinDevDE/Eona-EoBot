package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.ServerJoinedEvent;
import org.javacord.api.event.server.ServerJoinEvent;
import org.javacord.api.listener.server.ServerJoinListener;

public class AServerJoinListener implements ServerJoinListener {
    @Override
    public void onServerJoin(ServerJoinEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerJoinedEvent(e));
    }
}