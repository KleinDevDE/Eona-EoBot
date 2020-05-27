package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerSplashChangedEvent;
import org.javacord.api.event.server.ServerChangeSplashEvent;
import org.javacord.api.listener.server.ServerChangeSplashListener;

public class AServerChangeSplashListener implements ServerChangeSplashListener {
    @Override
    public void onServerChangeSplash(ServerChangeSplashEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerSplashChangedEvent(e));
    }
}