package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerIconChangedEvent;
import org.javacord.api.event.server.ServerChangeIconEvent;
import org.javacord.api.listener.server.ServerChangeIconListener;

public class AServerChangeIconListener implements ServerChangeIconListener {
    @Override
    public void onServerChangeIcon(ServerChangeIconEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerIconChangedEvent(e));
    }
}