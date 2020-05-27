package de.eonadev.discord.eobot.api.listeners.discord.roles;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.RoleChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.role.RoleCreatedEvent;
import org.javacord.api.event.server.role.RoleCreateEvent;
import org.javacord.api.listener.server.role.RoleCreateListener;

public class ARoleCreateListener implements RoleCreateListener {
    @Override
    public void onRoleCreate(RoleCreateEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new RoleChangedEvent(e.getApi(), e.getServer(), e.getRole()));
        EoBot.getInstance().getPluginManager().callEvent(new RoleCreatedEvent(e));
    }
}