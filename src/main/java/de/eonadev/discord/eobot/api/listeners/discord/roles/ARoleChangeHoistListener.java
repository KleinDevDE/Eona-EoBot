package de.eonadev.discord.eobot.api.listeners.discord.roles;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.RoleChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.role.RoleHoistChangedEvent;
import org.javacord.api.event.server.role.RoleChangeHoistEvent;
import org.javacord.api.listener.server.role.RoleChangeHoistListener;

public class ARoleChangeHoistListener implements RoleChangeHoistListener {
    @Override
    public void onRoleChangeHoist(RoleChangeHoistEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new RoleChangedEvent(e.getApi(), e.getServer(), e.getRole()));
        EoBot.getInstance().getPluginManager().callEvent(new RoleHoistChangedEvent(e));
    }
}