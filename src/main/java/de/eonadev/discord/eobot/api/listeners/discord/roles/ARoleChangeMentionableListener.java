package de.eonadev.discord.eobot.api.listeners.discord.roles;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.RoleChangedEvent;
import de.eonadev.discord.eobot.api.events.discord.role.RoleMentionableChangedEvent;
import org.javacord.api.event.server.role.RoleChangeMentionableEvent;
import org.javacord.api.listener.server.role.RoleChangeMentionableListener;

public class ARoleChangeMentionableListener implements RoleChangeMentionableListener {
    @Override
    public void onRoleChangeMentionable(RoleChangeMentionableEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new RoleChangedEvent(e.getApi(), e.getServer(), e.getRole()));
        EoBot.getInstance().getPluginManager().callEvent(new RoleMentionableChangedEvent(e));
    }
}