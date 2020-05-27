package de.eonadev.discord.eobot.api.listeners.discord.message;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.reaction.ReactionRemovedEvent;
import org.javacord.api.event.message.reaction.ReactionRemoveEvent;
import org.javacord.api.listener.message.reaction.ReactionRemoveListener;

public class AReactionRemoveListener implements ReactionRemoveListener {
    @Override
    public void onReactionRemove(ReactionRemoveEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ReactionRemovedEvent(e));
    }
}