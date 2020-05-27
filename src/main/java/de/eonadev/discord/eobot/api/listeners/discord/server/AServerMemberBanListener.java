package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.ServerMemberBannedEvent;
import org.javacord.api.event.server.member.ServerMemberBanEvent;
import org.javacord.api.listener.server.member.ServerMemberBanListener;

public class AServerMemberBanListener implements ServerMemberBanListener {
    @Override
    public void onServerMemberBan(ServerMemberBanEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ServerMemberBannedEvent(e));
    }
}