package de.eonadev.discord.eobot.api.listeners.discord.message;


import com.vdurmont.emoji.EmojiParser;
import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.Response;
import de.eonadev.discord.eobot.api.commands.base.ResponseTemplate;
import de.eonadev.discord.eobot.api.events.discord.message.MessageCreatedEvent;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class AMessageCreateListener implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent e) {
        EoBot.getInstance().getPluginManager().callEvent(new MessageCreatedEvent(e));


        // Command listening
        if (e.getMessageAuthor().isBotUser() || e.getMessageAuthor().isWebhook() || e.getMessageAuthor().isYourself())
            return;
        if (e.getMessage().getReadableContent().startsWith(EoBot.getInstance().getEoBotConfiguration().commandPrefix)){
            //TODO anti-flood checking!!
            String[] arr = e.getMessageContent().split(" ");
            String[] args = new String[arr.length - 1];
            System.arraycopy(arr, 1, args, 0, args.length);
            if (EoBot.getInstance().getPluginManager().isCommand(arr[0].replace("!", ""))) {
                Command command = EoBot.getInstance().getPluginManager().getCommand(arr[0].replace("!", ""));
                if (command == null){
                    Logger.log(LogType.FATAL, "Could not run command cause there is no existing class!");
                    return;
                }
                CommandInfo commandInfo = command.getClass().getAnnotation(CommandInfo.class);

                //TODO check permission
                Logger.log("Command \"" + arr[0].replace("!", "") + "\" executed by " + e.getMessageAuthor().getName());
                command.run(e.getMessage(), e.getChannel().getType(), e.getMessageContent(), args);
            } else {
                Response response = ResponseTemplate.help(e.getMessage());
                response.setText("Ich kenne diesen Befehl nicht " + EmojiParser.parseToUnicode(":face_with_monocle:"));
                response.setDeletionTime(5);
                response.send(true);
            }
        }
    }
}