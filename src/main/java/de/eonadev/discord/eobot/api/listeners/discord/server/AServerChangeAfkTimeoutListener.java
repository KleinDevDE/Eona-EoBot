package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerAFKTimeoutChangedEvent;
import org.javacord.api.event.server.ServerChangeAfkTimeoutEvent;
import org.javacord.api.listener.server.ServerChangeAfkTimeoutListener;

public class AServerChangeAfkTimeoutListener implements ServerChangeAfkTimeoutListener {
    @Override
    public void onServerChangeAfkTimeout(ServerChangeAfkTimeoutEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerAFKTimeoutChangedEvent(e));
    }
}