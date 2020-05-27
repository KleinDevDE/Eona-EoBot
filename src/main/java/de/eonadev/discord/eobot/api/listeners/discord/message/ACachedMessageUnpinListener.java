package de.eonadev.discord.eobot.api.listeners.discord.message;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.discord.message.CachedMessageUnpinnedEvent;
import org.javacord.api.event.message.CachedMessageUnpinEvent;
import org.javacord.api.listener.message.CachedMessageUnpinListener;

public class ACachedMessageUnpinListener implements CachedMessageUnpinListener {
    @Override
    public void onCachedMessageUnpin(CachedMessageUnpinEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new CachedMessageUnpinnedEvent(e));
    }
}