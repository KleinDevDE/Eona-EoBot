package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.ServerMemberUnbannedEvent;
import org.javacord.api.event.server.member.ServerMemberUnbanEvent;
import org.javacord.api.listener.server.member.ServerMemberUnbanListener;

public class AServerMemberUnbanListener implements ServerMemberUnbanListener {
    @Override
    public void onServerMemberUnban(ServerMemberUnbanEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerMemberUnbannedEvent(e));
    }
}