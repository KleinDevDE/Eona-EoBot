package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserRoleRemovedEvent;
import org.javacord.api.event.server.role.UserRoleRemoveEvent;
import org.javacord.api.listener.server.role.UserRoleRemoveListener;

public class AUserRoleRemoveListener implements UserRoleRemoveListener {
    @Override
    public void onUserRoleRemove(UserRoleRemoveEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserRoleRemovedEvent(e));
    }
}