package de.eonadev.discord.eobot.api.events.base;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled(boolean cancel);
}
