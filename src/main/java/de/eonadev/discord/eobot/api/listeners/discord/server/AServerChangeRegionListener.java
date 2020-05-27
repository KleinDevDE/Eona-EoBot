package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerRegionChangedEvent;
import org.javacord.api.event.server.ServerChangeRegionEvent;
import org.javacord.api.listener.server.ServerChangeRegionListener;

public class AServerChangeRegionListener implements ServerChangeRegionListener {
    @Override
    public void onServerChangeRegion(ServerChangeRegionEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerRegionChangedEvent(e));
    }
}