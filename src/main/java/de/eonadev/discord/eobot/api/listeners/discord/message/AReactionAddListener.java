package de.eonadev.discord.eobot.api.listeners.discord.message;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.reaction.ReactionAddedEvent;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

public class AReactionAddListener implements ReactionAddListener {
    @Override
    public void onReactionAdd(ReactionAddEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ReactionAddedEvent(e));
    }
}