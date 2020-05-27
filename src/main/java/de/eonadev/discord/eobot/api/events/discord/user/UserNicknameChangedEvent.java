package de.eonadev.discord.eobot.api.events.discord.user;

import org.javacord.api.entity.server.Server;
import org.javacord.api.DiscordApi;
import java.util.Optional;
import org.javacord.api.event.user.UserChangeNicknameEvent;
import de.eonadev.discord.eobot.api.events.base.Event;
import org.javacord.api.entity.user.User;





public class UserNicknameChangedEvent extends Event {
	private Optional<String> newNickname;
	private Server server;
	private Optional<String> oldNickname;
	private DiscordApi api;
	private User user;

	public UserNicknameChangedEvent(UserChangeNicknameEvent javaCordEvent) {
		this.newNickname = javaCordEvent.getNewNickname();
		this.server = javaCordEvent.getServer();
		this.oldNickname = javaCordEvent.getOldNickname();
		this.api = javaCordEvent.getApi();
		this.user = javaCordEvent.getUser();
	}

	public Optional<String> getNewNickname() {
		return newNickname;
	}

	public Server getServer() {
		return server;
	}

	public Optional<String> getOldNickname() {
		return oldNickname;
	}

	public DiscordApi getApi() {
		return api;
	}

	public User getUser() {
		return user;
	}

}
