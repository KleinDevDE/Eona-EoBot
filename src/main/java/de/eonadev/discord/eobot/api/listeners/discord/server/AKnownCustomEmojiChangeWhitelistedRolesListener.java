package de.eonadev.discord.eobot.api.listeners.discord.server;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.server.customemoji.CustomEmojiWhitelistedRolesChangedEvent;
import org.javacord.api.event.server.emoji.KnownCustomEmojiChangeWhitelistedRolesEvent;
import org.javacord.api.listener.server.emoji.KnownCustomEmojiChangeWhitelistedRolesListener;

public class AKnownCustomEmojiChangeWhitelistedRolesListener implements KnownCustomEmojiChangeWhitelistedRolesListener {
    @Override
    public void onKnownCustomEmojiChangeWhitelistedRoles(KnownCustomEmojiChangeWhitelistedRolesEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new CustomEmojiWhitelistedRolesChangedEvent(e));
    }
}