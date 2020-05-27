package de.eonadev.discord.eobot.api.events.discord.user;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.user.UserChangeStatusEvent;
import org.javacord.api.entity.user.UserStatus;
import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.entity.user.User;





public class UserStatusChangedEvent extends Event {
	private UserStatus oldDesktopStatus;
	private UserStatus newStatus;
	private UserStatus newDesktopStatus;
	private UserStatus oldStatus;
	private UserStatus newWebStatus;
	private UserStatus newMobileStatus;
	private UserStatus oldMobileStatus;
	private DiscordApi api;
	private User user;
	private UserStatus oldWebStatus;

	public UserStatusChangedEvent(UserChangeStatusEvent javaCordEvent) {
		this.oldDesktopStatus = javaCordEvent.getOldDesktopStatus();
		this.newStatus = javaCordEvent.getNewStatus();
		this.newDesktopStatus = javaCordEvent.getNewDesktopStatus();
		this.oldStatus = javaCordEvent.getOldStatus();
		this.newWebStatus = javaCordEvent.getNewWebStatus();
		this.newMobileStatus = javaCordEvent.getNewMobileStatus();
		this.oldMobileStatus = javaCordEvent.getOldMobileStatus();
		this.api = javaCordEvent.getApi();
		this.user = javaCordEvent.getUser();
		this.oldWebStatus = javaCordEvent.getOldWebStatus();
	}

	public UserStatus getOldDesktopStatus() {
		return oldDesktopStatus;
	}

	public UserStatus getNewStatus() {
		return newStatus;
	}

	public UserStatus getNewDesktopStatus() {
		return newDesktopStatus;
	}

	public UserStatus getOldStatus() {
		return oldStatus;
	}

	public UserStatus getNewWebStatus() {
		return newWebStatus;
	}

	public UserStatus getNewMobileStatus() {
		return newMobileStatus;
	}

	public UserStatus getOldMobileStatus() {
		return oldMobileStatus;
	}

	public DiscordApi getApi() {
		return api;
	}

	public User getUser() {
		return user;
	}

	public UserStatus getOldWebStatus() {
		return oldWebStatus;
	}

}
