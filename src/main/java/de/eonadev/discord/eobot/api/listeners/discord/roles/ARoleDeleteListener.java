package de.eonadev.discord.eobot.api.listeners.discord.roles;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.RoleChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.role.RoleDeletedEvent;
import org.javacord.api.event.server.role.RoleDeleteEvent;
import org.javacord.api.listener.server.role.RoleDeleteListener;

public class ARoleDeleteListener implements RoleDeleteListener {
    @Override
    public void onRoleDelete(RoleDeleteEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new RoleChangedEvent(e.getApi(), e.getServer(), e.getRole()));
        EoBot.getInstance().getPluginManager().callEvent(new RoleDeletedEvent(e));
    }
}