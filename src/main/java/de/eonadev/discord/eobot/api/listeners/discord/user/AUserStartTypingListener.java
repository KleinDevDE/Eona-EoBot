package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserStartedTypingEvent;
import org.javacord.api.event.user.UserStartTypingEvent;
import org.javacord.api.listener.user.UserStartTypingListener;

public class AUserStartTypingListener implements UserStartTypingListener {
    @Override
    public void onUserStartTyping(UserStartTypingEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserStartedTypingEvent(e));
    }
}