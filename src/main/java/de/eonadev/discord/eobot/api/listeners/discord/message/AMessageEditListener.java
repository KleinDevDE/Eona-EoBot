package de.eonadev.discord.eobot.api.listeners.discord.message;


import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.events.discord.message.MessageEditedEvent;
import de.eonadev.discord.eobot.utils.logging.Logger;
import org.javacord.api.event.message.MessageEditEvent;
import org.javacord.api.listener.message.MessageEditListener;

public class AMessageEditListener implements MessageEditListener {
    @Override
    public void onMessageEdit(MessageEditEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new MessageEditedEvent(e));


        if (!e.getMessage().isPresent() || !e.getMessageAuthor().isPresent() || e.getMessageContent().isPresent())
            return;
        if (e.getMessageAuthor().get().isBotUser() || e.getMessageAuthor().get().isWebhook() || e.getMessageAuthor().get().isYourself())
            return;
        if (e.getMessage().get().getCreationTimestamp().toEpochMilli() > (System.currentTimeMillis() + 7000))
            return;
        //TODO Check for spam
        if (e.getMessage().get().getReadableContent().startsWith(EoBot.getInstance().getEoBotConfiguration().commandPrefix)) {
            String cmd = (e.getMessageContent().get().split(" ")[0]).replace(EoBot.getInstance().getEoBotConfiguration().commandPrefix, "");
            if (EoBot.getInstance().getPluginManager().isCommand(cmd)) {
                Command command = EoBot.getInstance().getPluginManager().getCommand(cmd);
                CommandInfo commandInfo = command.getClass().getAnnotation(CommandInfo.class);
                String[] args = e.getMessageContent().get().replace(cmd, "").split(" ");
                //TODO check permission
                Logger.log("Command \"" + cmd + "\" executed by " + e.getMessageAuthor().get().getName());
                command.run(e.getMessage().get(), e.getChannel().getType(), e.getMessageContent().get(), args);
            }
        }
    }
}