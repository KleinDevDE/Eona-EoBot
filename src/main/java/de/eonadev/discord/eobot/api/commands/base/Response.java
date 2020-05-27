package de.eonadev.discord.eobot.api.commands.base;

import com.vdurmont.emoji.EmojiParser;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;
import de.eonadev.discord.eobot.utils.tools.MessageTools;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Response {

    private EmbedBuilder embedBuilder = new EmbedBuilder();
    private Channel channel;
    private Message message;
    private long deleteAfter = 5;
    ReactionAddListener reactionAddListener;
    List<String> emojis = new ArrayList<>();

    public Response(Message message) {
        this.channel = message.getChannel();
        this.message = message;
        initBuilder(message.getAuthor().getDisplayName());
    }

    Response(EmbedBuilder builder, Message message) {
        this.embedBuilder = builder;
        this.channel = message.getChannel();
        this.message = message;
    }

    public Response(Channel channel, User user){
        this.channel = channel;
        initBuilder(user.getName());
    }

    public Response setTitle(String title){
        embedBuilder.setTitle(title);
        return this;
    }

    public Response setText(String message){
        embedBuilder.setDescription(message);
        return this;
    }

    public Response addField(String key, String value, boolean inline){
        embedBuilder.addField(key, value, inline);
        return this;
    }

    public EmbedListBuilder getEmbedListBuilder(String title_left, String title_right){
        return new EmbedListBuilder(this, embedBuilder, title_left, title_right);
    }

    void setBuilder(EmbedBuilder embedBuilder) {
        this.embedBuilder = embedBuilder;
    }

    public Response setDeletionTime(long seconds) {
        deleteAfter = seconds;
        return this;
    }

    public Response setReactionAddListener(ReactionAddListener e) {
        this.reactionAddListener = e;
        return this;
    }

    public Response addReaction(String... emojis) {
        Logger.log(LogType.DEBUG, "Response.java:80 -- size " + emojis.length);
        for (String s : emojis)
            this.emojis.add(s);
        return this;
    }

    public Message send(boolean deleteCommandMessage) {
        Message msg;
        if (channel instanceof ServerTextChannel)
            if (deleteAfter < 0L)
                msg = channel.asServerTextChannel().get().sendMessage(embedBuilder).join();
            else {
                msg = channel.asServerTextChannel().get().sendMessage(embedBuilder).join();
                MessageTools.deleteMessageLater(msg, deleteAfter);
            }
        else if (channel instanceof PrivateChannel)
            msg = channel.asPrivateChannel().get().sendMessage(embedBuilder).join();
        else return null;

        if (msg != null && msg.getContent() != null) {
            for (String e : this.emojis) {
                Logger.log(LogType.DEBUG, "Response.java:100 -- loop - " + e);
                msg.addReaction(EmojiParser.parseToUnicode(e));
                Logger.log(LogType.DEBUG, "Response.java:102 -- loop next round");
            }
            Logger.log(LogType.DEBUG, "Response.java:104 -- addReactionAddListener");
            if (reactionAddListener != null)
                msg.addReactionAddListener(reactionAddListener);
        }

        if (message != null) {
            if (deleteCommandMessage)
                MessageTools.deleteMessageLater(message, 5);
        } else
            Logger.log(LogType.WARNING, "Response.send(true) could not delete commandMessage cause of there is no one existing!");
        return msg;
    }

    private void initBuilder(String author){
        embedBuilder.setColor(Color.CYAN);
        embedBuilder.setFooter("~"+author);
    }

    public static class EmbedListBuilder {
        private Response response;
        private EmbedBuilder builder;
        private String left_title;
        private String right_title;
        private ArrayList<String> left = new ArrayList<>();
        private ArrayList<String> right = new ArrayList<>();


        public EmbedListBuilder(Response response, EmbedBuilder builder, String title_left, String title_right) {
            this.builder = builder;
            this.left_title = title_left;
            this.right_title = title_right;
            this.response = response;
        }

        public EmbedListBuilder addLine(String left, String right) {
            this.left.add(left);
            this.right.add(right);
            return this;
        }

        public Response build() {
            StringBuilder stringBuilder_left = new StringBuilder();
            StringBuilder stringBuilder_right = new StringBuilder();
            for (int count = 0; count <= left.size()-1; count++) {
                stringBuilder_left.append("\n").append(left.get(count));
                stringBuilder_right.append("\n").append(right.get(count));
            }
            builder.addInlineField(left_title, stringBuilder_left.toString());
            builder.addInlineField(right_title, stringBuilder_right.toString());
            response.setBuilder(builder);
            return response;
        }
    }
}
