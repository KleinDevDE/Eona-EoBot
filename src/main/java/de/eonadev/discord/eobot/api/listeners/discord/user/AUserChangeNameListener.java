package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserNameChangedEvent;
import org.javacord.api.event.user.UserChangeNameEvent;
import org.javacord.api.listener.user.UserChangeNameListener;

public class AUserChangeNameListener implements UserChangeNameListener {
    @Override
    public void onUserChangeName(UserChangeNameEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserNameChangedEvent(e));
    }
}