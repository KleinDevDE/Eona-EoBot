package de.eonadev.discord.eobot.api.events.discord.user;

import org.javacord.api.entity.server.Server;
import org.javacord.api.DiscordApi;
import org.javacord.api.event.user.UserChangeSelfDeafenedEvent;
import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.entity.user.User;





public class UserSelfDeafenChangedEvent extends Event {
	private Server server;
	private DiscordApi api;
	private User user;

	public UserSelfDeafenChangedEvent(UserChangeSelfDeafenedEvent javaCordEvent) {
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
