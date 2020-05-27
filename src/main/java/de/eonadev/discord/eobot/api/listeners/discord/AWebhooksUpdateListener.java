package de.eonadev.discord.eobot.api.listeners.discord;


import de.eonadev.discord.eobot.api.EoBot;
import org.javacord.api.event.channel.server.text.WebhooksUpdateEvent;
import org.javacord.api.listener.channel.server.text.WebhooksUpdateListener;

public class AWebhooksUpdateListener implements WebhooksUpdateListener {
    @Override
    public void onWebhooksUpdate(WebhooksUpdateEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new de.eonadev.discord.eobot.api.events.discord.channels.WebhooksUpdateEvent(e));
    }
}