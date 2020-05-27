package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserAvatarChangedEvent;
import org.javacord.api.event.user.UserChangeAvatarEvent;
import org.javacord.api.listener.user.UserChangeAvatarListener;

public class AUserChangeAvatarListener implements UserChangeAvatarListener {
    @Override
    public void onUserChangeAvatar(UserChangeAvatarEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserAvatarChangedEvent(e));
    }
}