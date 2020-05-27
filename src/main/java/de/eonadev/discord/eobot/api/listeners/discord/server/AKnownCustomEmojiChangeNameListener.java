package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.customemoji.CustomEmojiNameChangedEvent;
import org.javacord.api.event.server.emoji.KnownCustomEmojiChangeNameEvent;
import org.javacord.api.listener.server.emoji.KnownCustomEmojiChangeNameListener;

public class AKnownCustomEmojiChangeNameListener implements KnownCustomEmojiChangeNameListener {
    @Override
    public void onKnownCustomEmojiChangeName(KnownCustomEmojiChangeNameEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new CustomEmojiNameChangedEvent(e));
    }
}