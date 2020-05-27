package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserMuteChangedEvent;
import org.javacord.api.event.user.UserChangeMutedEvent;
import org.javacord.api.listener.user.UserChangeMutedListener;

public class AUserChangeMutedListener implements UserChangeMutedListener {
    @Override
    public void onUserChangeMuted(UserChangeMutedEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserMuteChangedEvent(e));
    }
}