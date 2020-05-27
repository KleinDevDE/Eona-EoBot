package de.eonadev.discord.eobot.api.events.discord.user;

import org.javacord.api.entity.activity.Activity;
import org.javacord.api.event.user.UserChangeActivityEvent;
import org.javacord.api.DiscordApi;
import java.util.Optional;
import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.entity.user.User;




public class UserActivityChangedEvent extends Event {
	private Optional<Activity> oldActivity;
	private Optional<Activity> newActivity;
	private DiscordApi api;
	private User user;

	public UserActivityChangedEvent(UserChangeActivityEvent javaCordEvent) {
		this.oldActivity = javaCordEvent.getOldActivity();
		this.newActivity = javaCordEvent.getNewActivity();
		this.api = javaCordEvent.getApi();
		this.user = javaCordEvent.getUser();
	}

	public Optional<Activity> getOldActivity() {
		return oldActivity;
	}

	public Optional<Activity> getNewActivity() {
		return newActivity;
	}

	public DiscordApi getApi() {
		return api;
	}

	public User getUser() {
		return user;
	}

}
