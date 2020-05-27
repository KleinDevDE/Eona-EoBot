package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserStatusChangedEvent;
import org.javacord.api.event.user.UserChangeStatusEvent;
import org.javacord.api.listener.user.UserChangeStatusListener;

public class AUserChangeStatusListener implements UserChangeStatusListener {
    @Override
    public void onUserChangeStatus(UserChangeStatusEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserStatusChangedEvent(e));
    }
}