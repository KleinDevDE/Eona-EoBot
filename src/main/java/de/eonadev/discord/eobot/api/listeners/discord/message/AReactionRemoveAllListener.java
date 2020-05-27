package de.eonadev.discord.eobot.api.listeners.discord.message;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.channels.reaction.ReactionAllRemovedEvent;
import org.javacord.api.event.message.reaction.ReactionRemoveAllEvent;
import org.javacord.api.listener.message.reaction.ReactionRemoveAllListener;

public class AReactionRemoveAllListener implements ReactionRemoveAllListener {
    @Override
    public void onReactionRemoveAll(ReactionRemoveAllEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new ReactionAllRemovedEvent(e));
    }
}