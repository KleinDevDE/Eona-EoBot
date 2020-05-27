package de.eonadev.discord.eobot.api.events.discord.server.customemoji;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.emoji.KnownCustomEmoji;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.emoji.KnownCustomEmojiChangeNameEvent;


public class CustomEmojiNameChangedEvent extends Event {
    private String oldName;
    private String newName;
    private KnownCustomEmoji knownCustomEmoji;
    private DiscordApi api;
    private Server server;

    public CustomEmojiNameChangedEvent(KnownCustomEmojiChangeNameEvent e){
        knownCustomEmoji = e.getEmoji();
        api = e.getApi();
        server = e.getServer();
        oldName = e.getOldName();
        newName = e.getNewName();
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

    public String getNewName() {
        return newName;
    }

    public String getOldName() {
        return oldName;
    }
}
