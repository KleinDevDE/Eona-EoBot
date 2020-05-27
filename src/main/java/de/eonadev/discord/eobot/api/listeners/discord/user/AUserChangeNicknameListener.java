package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserNicknameChangedEvent;
import org.javacord.api.event.user.UserChangeNicknameEvent;
import org.javacord.api.listener.user.UserChangeNicknameListener;

public class AUserChangeNicknameListener implements UserChangeNicknameListener {
    @Override
    public void onUserChangeNickname(UserChangeNicknameEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserNicknameChangedEvent(e));
    }
}