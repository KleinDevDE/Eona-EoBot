package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerOwnerChangedEvent;
import org.javacord.api.event.server.ServerChangeOwnerEvent;
import org.javacord.api.listener.server.ServerChangeOwnerListener;

public class AServerChangeOwnerListener implements ServerChangeOwnerListener {
    @Override
    public void onServerChangeOwner(ServerChangeOwnerEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerOwnerChangedEvent(e));
    }
}