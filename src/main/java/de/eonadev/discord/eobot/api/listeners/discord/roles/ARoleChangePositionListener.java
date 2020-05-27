package de.eonadev.discord.eobot.api.listeners.discord.roles;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.RoleChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.role.RolePositionChangedEvent;
import org.javacord.api.event.server.role.RoleChangePositionEvent;
import org.javacord.api.listener.server.role.RoleChangePositionListener;

public class ARoleChangePositionListener implements RoleChangePositionListener {
    @Override
    public void onRoleChangePosition(RoleChangePositionEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new RoleChangedEvent(e.getApi(), e.getServer(), e.getRole()));
        EoBot.getInstance().getPluginManager().callEvent(new RolePositionChangedEvent(e));
    }
}