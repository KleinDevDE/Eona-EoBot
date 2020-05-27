package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserSelfDeafenChangedEvent;
import org.javacord.api.event.user.UserChangeSelfDeafenedEvent;
import org.javacord.api.listener.user.UserChangeSelfDeafenedListener;

public class AUserChangeSelfDeafenedListener implements UserChangeSelfDeafenedListener {
    @Override
    public void onUserChangeSelfDeafened(UserChangeSelfDeafenedEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserSelfDeafenChangedEvent(e));
    }
}