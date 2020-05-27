package de.eonadev.discord.eobot.api.events.discord.server.customemoji;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.emoji.KnownCustomEmoji;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.emoji.KnownCustomEmojiCreateEvent;


public class CustomEmojiCreatedEvent extends Event {
    private KnownCustomEmoji knownCustomEmoji;
    private DiscordApi api;
    private Server server;

    public CustomEmojiCreatedEvent(KnownCustomEmojiCreateEvent e){
        knownCustomEmoji = e.getEmoji();
        api = e.getApi();
        server = e.getServer();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Server getServer() {
        return server;
    }

    public KnownCustomEmoji getKnownCustomEmoji() {
        return knownCustomEmoji;
    }
}
