package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.customemoji.CustomEmojiDeletedEvent;
import org.javacord.api.event.server.emoji.KnownCustomEmojiDeleteEvent;
import org.javacord.api.listener.server.emoji.KnownCustomEmojiDeleteListener;

public class AKnownCustomEmojiDeleteListener implements KnownCustomEmojiDeleteListener {
    @Override
    public void onKnownCustomEmojiDelete(KnownCustomEmojiDeleteEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new CustomEmojiDeletedEvent(e));
    }
}