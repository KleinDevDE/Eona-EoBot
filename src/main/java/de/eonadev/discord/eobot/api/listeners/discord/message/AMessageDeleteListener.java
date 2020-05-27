package de.eonadev.discord.eobot.api.listeners.discord.message;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.message.MessageDeletedEvent;
import org.javacord.api.event.message.MessageDeleteEvent;
import org.javacord.api.listener.message.MessageDeleteListener;

public class AMessageDeleteListener implements MessageDeleteListener {
    @Override
    public void onMessageDelete(MessageDeleteEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new MessageDeletedEvent(e));
    }
}