package de.eonadev.discord.eobot.api.commands.discord;

import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import de.eonadev.discord.eobot.utils.ApplicationManager;
import de.eonadev.discord.eobot.utils.logging.Logger;
import org.javacord.api.entity.channel.ChannelType;
import org.javacord.api.entity.message.Message;

import java.io.IOException;

@CommandInfo(cmd = "reboot", permission = "eobot.system.reboot", description = "Restart this bot")
public class RebootDiscordCommand extends Command {
    @Override
    public void run(Message message, ChannelType channelType, String messageContent, String[] args) {
        try {
            Response response = new Response(message);
            response.setText("Rebooting..");
            response.setDeletionTime(-1L);
            response.send(false);
            Logger.log("Restart initiated by " + message.getAuthor().getName()+message.getAuthor().asUser());
            ApplicationManager.restartApplication(null);
        } catch (IOException e) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        }
    }
}
