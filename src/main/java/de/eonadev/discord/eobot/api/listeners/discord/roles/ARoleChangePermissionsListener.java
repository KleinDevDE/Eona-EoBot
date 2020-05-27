package de.eonadev.discord.eobot.api.listeners.discord.roles;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.RoleChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.role.RolePermissionsChangedEvent;
import org.javacord.api.event.server.role.RoleChangePermissionsEvent;
import org.javacord.api.listener.server.role.RoleChangePermissionsListener;

public class ARoleChangePermissionsListener implements RoleChangePermissionsListener {
    @Override
    public void onRoleChangePermissions(RoleChangePermissionsEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new RoleChangedEvent(e.getApi(), e.getServer(), e.getRole()));
        EoBot.getInstance().getPluginManager().callEvent(new RolePermissionsChangedEvent(e));
    }
}