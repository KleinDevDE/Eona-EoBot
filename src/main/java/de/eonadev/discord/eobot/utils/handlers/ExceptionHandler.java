package de.eonadev.discord.eobot.utils.handlers;

import de.eonadev.discord.eobot.Main;
import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.EmbedListBuilder;
import de.eonadev.discord.eobot.utils.ApplicationManager;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;
import de.eonadev.discord.eobot.utils.mappings.Members;
import de.eonadev.discord.eobot.utils.mappings.Roles;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private static StackTraceElement[] lastStackTrace;
    private static long lastException = 0L;
    private static int count = 0;

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        handle(e);
    }

    public static void handle(Throwable e){
        
        //If there are 10+ exceptions in 3 seconds, the bot will reboot
        // If the reboot failed, bot will shutdown
        count++;
        if (count >= 10) {
            if (lastException != 0L && (System.currentTimeMillis() - lastException) <= 3000) {
                Logger.log(LogType.FATAL, "Too many exceptions! Forcing reboot..");
                try {
                    ApplicationManager.restartApplication(null);
                    return;
                } catch (IOException ex) {
                    Logger.log(LogType.FATAL, "Failed to reboot! Forcing shutdown..");
                    //TODO send Webhook, SMS, Telegram or something else to me
                    System.exit(0);
                }
            }
        } else {
            lastException = System.currentTimeMillis();
            count = 0;
        }
        


        // Skip if last Stacktrace is the same
        if (lastStackTrace != null && Arrays.equals(lastStackTrace, e.getStackTrace()))
            return;
        lastStackTrace = e.getStackTrace();


        Logger.log(LogType.ERROR, "An Exception was thrown!");
        e.printStackTrace();
        if (EoBot.getInstance() != null && EoBot.getInstance().getApi() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            StringBuilder lastLogs = new StringBuilder();
            StringBuilder out = new StringBuilder();
            StringBuilder args = new StringBuilder();
            StringBuilder jvm_args = new StringBuilder();
            EmbedBuilder embedBuilder = new EmbedBuilder();
            e.printStackTrace(pw);
            embedBuilder.setColor(Color.RED);
            embedBuilder.setTitle("New Exception thrown!");
            int size = Logger.getLastLogs().size();
            for (String s : Logger.getLastLogs()) {
                size--;
                if (size > 10)
                    continue;
                lastLogs.append(s).append("\n");
            }
            for (String s : Main.getArgs())
                args.append(s).append(" ");
            for (String s : ManagementFactory.getRuntimeMXBean().getInputArguments())
                jvm_args.append(s).append(" ");

            out.append("**StackTrace**").append("\n");
            out.append("```").append(sw.toString()).append("```");
            out.append("\n");
            out.append("\n").append("**Last 10 log messages**").append("\n");
            out.append("```").append(lastLogs.toString()).append("```").append("\n");
            out.append("\n");
            out.append("\n");
            EmbedListBuilder embedListBuilder = new EmbedListBuilder(embedBuilder, "Key", "Value");
            embedListBuilder.addLine("OS", System.getProperty("os.name"));
            embedListBuilder.addLine("Working directory", new File("./").getAbsolutePath());
            embedListBuilder.addLine("JVM Parameters", jvm_args.toString());
            embedListBuilder.addLine("Start arguments", args.toString());
            embedListBuilder.addLine("Thread ID", String.valueOf(Thread.currentThread().getId()));
            embedBuilder = embedListBuilder.build();
            embedBuilder.setDescription(out.toString());
            embedBuilder.setFooter(FORMAT.format(new Date()) + "  ~" + Main.VERSION);

            for (User user : EoBot.getInstance().getApi().getServerById(
                    EoBot.getInstance().getServerID()).get().getRoleById(Roles.TECHNIK.getRoleID()).get().getUsers()) {
                if (user.getId() == Members.KLEINDEV.getId()) {
                    user.sendMessage(embedBuilder);
                }
            }
        }
        
    }
}