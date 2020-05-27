package de.eonadev.discord.eobot.api.events.discord.user;

import org.javacord.api.entity.server.Server;
import org.javacord.api.DiscordApi;
import org.javacord.api.event.server.role.UserRoleRemoveEvent;
import org.javacord.api.entity.permission.Role;
import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.entity.user.User;





public class UserRoleRemovedEvent extends Event {
	private Server server;
	private Role role;
	private DiscordApi api;
	private User user;

	public UserRoleRemovedEvent(UserRoleRemoveEvent javaCordEvent) {
		this.server = javaCordEvent.getServer();
		this.role = javaCordEvent.getRole();
		this.api = javaCordEvent.getApi();
		this.user = javaCordEvent.getUser();
	}

	public Server getServer() {
		return server;
	}

	public Role getRole() {
		return role;
	}

	public DiscordApi getApi() {
		return api;
	}

	public User getUser() {
		return user;
	}

}
