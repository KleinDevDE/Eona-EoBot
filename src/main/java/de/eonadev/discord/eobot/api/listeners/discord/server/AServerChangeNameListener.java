package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.ServerChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.server.ServerNameChangedEvent;
import org.javacord.api.event.server.ServerChangeNameEvent;
import org.javacord.api.listener.server.ServerChangeNameListener;

public class AServerChangeNameListener implements ServerChangeNameListener {
    @Override
    public void onServerChangeName(ServerChangeNameEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerChangedEvent());
        EoBot.getInstance().getPluginManager().callEvent(new ServerNameChangedEvent(e));
    }
}