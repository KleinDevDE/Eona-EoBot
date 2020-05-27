package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserRoleAddedEvent;
import org.javacord.api.event.server.role.UserRoleAddEvent;
import org.javacord.api.listener.server.role.UserRoleAddListener;

public class AUserRoleAddListener implements UserRoleAddListener {
    @Override
    public void onUserRoleAdd(UserRoleAddEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserRoleAddedEvent(e));
    }
}