package de.eonadev.discord.eobot.api.listeners.discord.message;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.message.CachedMessagePinnedEvent;
import org.javacord.api.event.message.CachedMessagePinEvent;
import org.javacord.api.listener.message.CachedMessagePinListener;

public class ACachedMessagePinListener implements CachedMessagePinListener {
    @Override
    public void onCachedMessagePin(CachedMessagePinEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new CachedMessagePinnedEvent(e));
    }
}