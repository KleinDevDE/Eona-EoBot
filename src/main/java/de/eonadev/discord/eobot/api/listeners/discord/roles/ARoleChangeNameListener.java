package de.eonadev.discord.eobot.api.listeners.discord.roles;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.RoleChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.role.RoleNameChangedEvent;
import org.javacord.api.event.server.role.RoleChangeNameEvent;
import org.javacord.api.listener.server.role.RoleChangeNameListener;

public class ARoleChangeNameListener implements RoleChangeNameListener {
    @Override
    public void onRoleChangeName(RoleChangeNameEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new RoleChangedEvent(e.getApi(), e.getServer(), e.getRole()));
        EoBot.getInstance().getPluginManager().callEvent(new RoleNameChangedEvent(e));
    }
}