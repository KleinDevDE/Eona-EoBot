package de.eonadev.discord.eobot.api.commands.base;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;

public class ResponseTemplate {
    public static Response error(Message message){
        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(Color.RED);
        builder.setFooter("~"+message.getAuthor().getName());
        return new Response(builder, message);
    }

    public static Response help(Message message){
        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(Color.GRAY);
        builder.setFooter("~"+message.getAuthor().getName());
        return new Response(builder, message);
    }
}
