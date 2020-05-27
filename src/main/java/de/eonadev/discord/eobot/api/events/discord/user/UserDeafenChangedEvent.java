package de.eonadev.discord.eobot.api.events.discord.user;

import org.javacord.api.entity.server.Server;
import org.javacord.api.DiscordApi;
import org.javacord.api.event.user.UserChangeDeafenedEvent;
import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.entity.user.User;




public class UserDeafenChangedEvent extends Event {
	private Server server;
	private DiscordApi api;
	private User user;

	public UserDeafenChangedEvent(UserChangeDeafenedEvent javaCordEvent) {
		this.server = javaCordEvent.getServer();
		this.api = javaCordEvent.getApi();
		this.user = javaCordEvent.getUser();
	}

	public Server getServer() {
		return server;
	}

	public DiscordApi getApi() {
		return api;
	}

	public User getUser() {
		return user;
	}

}
