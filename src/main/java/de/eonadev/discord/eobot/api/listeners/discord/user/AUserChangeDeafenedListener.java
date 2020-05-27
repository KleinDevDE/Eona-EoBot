package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserDeafenChangedEvent;
import org.javacord.api.event.user.UserChangeDeafenedEvent;
import org.javacord.api.listener.user.UserChangeDeafenedListener;

public class AUserChangeDeafenedListener implements UserChangeDeafenedListener {
    @Override
    public void onUserChangeDeafened(UserChangeDeafenedEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserDeafenChangedEvent(e));
    }
}