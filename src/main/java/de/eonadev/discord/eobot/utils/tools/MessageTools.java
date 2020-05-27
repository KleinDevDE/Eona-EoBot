package de.eonadev.discord.eobot.utils.tools;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import java.util.ArrayList;

public class MessageTools {
    private static ArrayList<Long> messagesWhoDontNeedToBeLogged = new ArrayList<>();

    static {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5184000);
                    Logger.log(LogType.DEBUG, "Clearing \"messagesWhoDontNeedToBeLogged\" list...");
                    messagesWhoDontNeedToBeLogged.clear();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
		}).start();
	}
	
    public static void deleteMessageLater(TextChannel channel, long messageID, long seconds){
        if(seconds <= -1)
            return;
        messagesWhoDontNeedToBeLogged.add(messageID);
        new Thread(() -> {
            try {
                if(channel.getId() == 585562006023569418L)
                    return;
                Thread.sleep(1000*seconds);
                EoBot.getInstance().getApi().getMessageById(messageID, channel).join().delete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void deleteMessageLater(Message message, long seconds){
        if(seconds <= -1)
            return;
        messagesWhoDontNeedToBeLogged.add(message.getId());
        new Thread(() -> {
            try {
                if(message.getChannel().getId() == 585562006023569418L)
                    return;
                Thread.sleep(1000*seconds);
                message.delete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static String getMessageURL(Message message){
        return "https.//discordapp.com/"+message.getServer().get().getId()+"/"+message.getChannel().getId()+"/"+message.getIdAsString();
    }
    
    public static void preventMessageFromDeleteLogging(long messageID) {
    	messagesWhoDontNeedToBeLogged.add(messageID);
    }
    
    public static void preventMessageFromDeleteLogging(Message message) {
    	preventMessageFromDeleteLogging(message.getId());
    }
    
    public static boolean isMessageDeletionIgnored(long messageID) {
    	return messagesWhoDontNeedToBeLogged.contains(messageID);
    }
    
    public static boolean isMessageDeletionIgnored(Message message) {
    	return isMessageDeletionIgnored(message.getId());
    }
    
    public static void removeMessageFromDeletionLogging(long messageID) {
    	messagesWhoDontNeedToBeLogged.remove(messageID);
    }
    
    public static void removeMessageFromDeletionLogging(Message message) {
    	removeMessageFromDeletionLogging(message.getId());
    }
}
