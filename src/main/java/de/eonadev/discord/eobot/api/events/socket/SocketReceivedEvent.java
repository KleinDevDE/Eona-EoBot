package de.eonadev.discord.eobot.api.events.socket;

import com.google.gson.JsonObject;
import de.eonadev.discord.eobot.api.events.base.Cancellable;
import de.eonadev.discord.eobot.api.events.base.Event;

import java.net.InetAddress;

public class SocketReceivedEvent extends Event implements Cancellable {
    private JsonObject jsonObject;
    private InetAddress sender;
    private boolean cancelled = false;

    public SocketReceivedEvent(JsonObject jsonObject, InetAddress sender){
        this.jsonObject = jsonObject;
        this.sender = sender;
    }

    public InetAddress getSender() {
        return sender;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
