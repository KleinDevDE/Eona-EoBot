package de.eonadev.discord.eobot.api.events.discord.server.customemoji;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.emoji.KnownCustomEmoji;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.emoji.KnownCustomEmojiChangeWhitelistedRolesEvent;

import java.util.Collection;
import java.util.Optional;


public class CustomEmojiWhitelistedRolesChangedEvent extends Event {
    private KnownCustomEmoji knownCustomEmoji;
    private DiscordApi api;
    private Server server;
    private Optional<Collection<Role>> newWhitelistedRoles;
    private Optional<Collection<Role>> oldWhitelsitedRoles;

    public CustomEmojiWhitelistedRolesChangedEvent(KnownCustomEmojiChangeWhitelistedRolesEvent e){
        knownCustomEmoji = e.getEmoji();
        api = e.getApi();
        server = e.getServer();
        newWhitelistedRoles = e.getNewWhitelistedRoles();
        oldWhitelsitedRoles = e.getOldWhitelistedRoles();
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

    public Optional<Collection<Role>> getNewWhitelistedRoles() {
        return newWhitelistedRoles;
    }

    public Optional<Collection<Role>> getOldWhitelsitedRoles() {
        return oldWhitelsitedRoles;
    }
}
