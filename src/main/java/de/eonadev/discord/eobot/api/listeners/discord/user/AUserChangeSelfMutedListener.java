package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserSelfMuteChangedEvent;
import org.javacord.api.event.user.UserChangeSelfMutedEvent;
import org.javacord.api.listener.user.UserChangeSelfMutedListener;

public class AUserChangeSelfMutedListener implements UserChangeSelfMutedListener {
    @Override
    public void onUserChangeSelfMuted(UserChangeSelfMutedEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserSelfMuteChangedEvent(e));
    }
}