package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.customemoji.CustomEmojiCreatedEvent;
import org.javacord.api.event.server.emoji.KnownCustomEmojiCreateEvent;
import org.javacord.api.listener.server.emoji.KnownCustomEmojiCreateListener;

public class AKnownCustomEmojiCreateListener implements KnownCustomEmojiCreateListener {
    @Override
    public void onKnownCustomEmojiCreate(KnownCustomEmojiCreateEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new CustomEmojiCreatedEvent(e));
    }
}