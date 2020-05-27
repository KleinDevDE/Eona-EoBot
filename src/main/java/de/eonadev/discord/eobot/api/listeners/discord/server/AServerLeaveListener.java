package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.ServerLeavedEvent;
import org.javacord.api.event.server.ServerLeaveEvent;
import org.javacord.api.listener.server.ServerLeaveListener;

public class AServerLeaveListener implements ServerLeaveListener {
    @Override
    public void onServerLeave(ServerLeaveEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerLeavedEvent(e));
    }
}