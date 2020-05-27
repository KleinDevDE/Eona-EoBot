package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserActivityChangedEvent;
import org.javacord.api.event.user.UserChangeActivityEvent;
import org.javacord.api.listener.user.UserChangeActivityListener;

public class AUserChangeActivityListener implements UserChangeActivityListener {
    @Override
    public void onUserChangeActivity(UserChangeActivityEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserActivityChangedEvent(e));
    }
}