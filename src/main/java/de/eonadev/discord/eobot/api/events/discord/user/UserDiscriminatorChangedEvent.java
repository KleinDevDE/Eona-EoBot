package de.eonadev.discord.eobot.api.events.discord.user;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.user.UserChangeDiscriminatorEvent;
import java.lang.String;
import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.entity.user.User;





public class UserDiscriminatorChangedEvent extends Event {
	private String oldDiscriminator;
	private String newDiscriminator;
	private DiscordApi api;
	private User user;

	public UserDiscriminatorChangedEvent(UserChangeDiscriminatorEvent javaCordEvent) {
		this.oldDiscriminator = javaCordEvent.getOldDiscriminator();
		this.newDiscriminator = javaCordEvent.getNewDiscriminator();
		this.api = javaCordEvent.getApi();
		this.user = javaCordEvent.getUser();
	}

	public String getOldDiscriminator() {
		return oldDiscriminator;
	}

	public String getNewDiscriminator() {
		return newDiscriminator;
	}

	public DiscordApi getApi() {
		return api;
	}

	public User getUser() {
		return user;
	}

	
}
