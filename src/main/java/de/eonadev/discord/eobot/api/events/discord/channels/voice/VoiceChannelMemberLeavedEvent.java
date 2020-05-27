package de.eonadev.discord.eobot.api.events.discord.channels.voice;

import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberLeaveEvent;

import java.util.Optional;


public class VoiceChannelMemberLeavedEvent extends Event {
	private Server server;
	private ServerVoiceChannel channel;
	private DiscordApi api;
	private Optional newChannel;
	private User user;

	public VoiceChannelMemberLeavedEvent(ServerVoiceChannelMemberLeaveEvent javaCordEvent) {
		this.server = javaCordEvent.getServer();
		this.channel = javaCordEvent.getChannel();
		this.api = javaCordEvent.getApi();
		this.newChannel = javaCordEvent.getNewChannel();
		this.user = javaCordEvent.getUser();
	}

	public Server getServer() {
		return server;
	}

	public ServerVoiceChannel getChannel() {
		return channel;
	}

	public DiscordApi getApi() {
		return api;
	}

	public Optional getNewChannel() {
		return newChannel;
	}

	public User getUser() {
		return user;
	}

}
