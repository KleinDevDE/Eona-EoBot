package de.eonadev.discord.eobot.api.events.discord.channels.voice;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelChangeUserLimitEvent;

import java.util.Optional;


public class VoiceChannelUserLimitChangedEvent extends Event {
	private Optional<Integer> newUserLimit;
	private Server server;
	private ServerVoiceChannel channel;
	private Optional<Integer> oldUserLimit;
	private DiscordApi api;

	public VoiceChannelUserLimitChangedEvent(ServerVoiceChannelChangeUserLimitEvent javaCordEvent) {
		this.newUserLimit = javaCordEvent.getNewUserLimit();
		this.server = javaCordEvent.getServer();
		this.channel = javaCordEvent.getChannel();
		this.oldUserLimit = javaCordEvent.getOldUserLimit();
		this.api = javaCordEvent.getApi();
	}

	public Optional getNewUserLimit() {
		return newUserLimit;
	}

	public Server getServer() {
		return server;
	}

	public ServerVoiceChannel getChannel() {
		return channel;
	}

	public Optional getOldUserLimit() {
		return oldUserLimit;
	}

	public DiscordApi getApi() {
		return api;
	}

}
