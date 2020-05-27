package de.eonadev.discord.eobot.api.listeners.discord.user;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.user.UserDiscriminatorChangedEvent;
import org.javacord.api.event.user.UserChangeDiscriminatorEvent;
import org.javacord.api.listener.user.UserChangeDiscriminatorListener;

public class AUserChangeDiscriminatorListener implements UserChangeDiscriminatorListener {
    @Override
    public void onUserChangeDiscriminator(UserChangeDiscriminatorEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new UserDiscriminatorChangedEvent(e));
    }
}