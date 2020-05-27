package de.eonadev.discord.eobot.api.listeners.discord.roles;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.RoleChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.role.RoleColorChangedEvent;
import org.javacord.api.event.server.role.RoleChangeColorEvent;
import org.javacord.api.listener.server.role.RoleChangeColorListener;

public class ARoleChangeColorListener implements RoleChangeColorListener {
    @Override
    public void onRoleChangeColor(RoleChangeColorEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new RoleChangedEvent(e.getApi(), e.getServer(), e.getRole()));
        EoBot.getInstance().getPluginManager().callEvent(new RoleColorChangedEvent(e));
    }
}