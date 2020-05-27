package de.eonadev.discord.eobot.api.events.discord.user;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.user.UserChangeAvatarEvent;
import org.javacord.api.entity.Icon;
import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.entity.user.User;



public class UserAvatarChangedEvent extends Event {
	private Icon oldAvatar;
	private Icon newAvatar;
	private DiscordApi api;
	private User user;

	public UserAvatarChangedEvent(UserChangeAvatarEvent javaCordEvent) {
		this.oldAvatar = javaCordEvent.getOldAvatar();
		this.newAvatar = javaCordEvent.getNewAvatar();
		this.api = javaCordEvent.getApi();
		this.user = javaCordEvent.getUser();
	}

	public Icon getOldAvatar() {
		return oldAvatar;
	}

	public Icon getNewAvatar() {
		return newAvatar;
	}

	public DiscordApi getApi() {
		return api;
	}

	public User getUser() {
		return user;
	}

}
