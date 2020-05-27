package de.eonadev.discord.eobot;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.events.application.EoBotShutdownEvent;
import de.eonadev.discord.eobot.api.events.discord.DiscordLoginEvent;
import de.eonadev.discord.eobot.api.listeners.discord.ALostConnectionListener;
import de.eonadev.discord.eobot.api.listeners.discord.AReconnectListener;
import de.eonadev.discord.eobot.api.listeners.discord.AResumeListener;
import de.eonadev.discord.eobot.api.listeners.discord.AWebhooksUpdateListener;
import de.eonadev.discord.eobot.api.listeners.discord.channel.*;
import de.eonadev.discord.eobot.api.listeners.discord.message.*;
import de.eonadev.discord.eobot.api.listeners.discord.roles.*;
import de.eonadev.discord.eobot.api.listeners.discord.server.*;
import de.eonadev.discord.eobot.api.listeners.discord.user.*;
import de.eonadev.discord.eobot.api.managers.CommandManager;
import de.eonadev.discord.eobot.utils.ApplicationManager;
import de.eonadev.discord.eobot.utils.MySQLConnection;
import de.eonadev.discord.eobot.utils.SecurityManagement;
import de.eonadev.discord.eobot.utils.handlers.ExceptionHandler;
import de.eonadev.discord.eobot.utils.logging.Logger;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.user.UserStatus;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public final static String VERSION = "1.0-pre2";
    private static String[] savedArgs;
    public static String[] getArgs() {
        return savedArgs;
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManagement());
        FallbackLoggerConfiguration.setDebug(false);
        FallbackLoggerConfiguration.setTrace(false);
        savedArgs = args;
        new EoBot();
        new Logger(new File(EoBot.getInstance().getEoBotConfiguration().logsFolder));
        if (!new File("local").exists()) {
            EoBot.getInstance().registerMySQLConnection("eocore", new MySQLConnection("database.local", "3306", "app_eocore", "app_eocore",
                    "XXX", true, false, true));
            EoBot.getInstance().registerMySQLConnection("eobot", new MySQLConnection("database.local", "3306", "app_eobot", "app_eobot",
                    "XXX", true, false, true));
        }
        CommandManager.registerInternalCommands();
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        checkArgs(args);
        registerShutdownHook();
        initBot();
        listenCommands();
        loadPlugins();
        Logger.log("EoBot started!");
    }

    private static void checkArgs(String[]args){

    }

    private static void loadPlugins() {
        for (File f : new File(EoBot.getInstance().getEoBotConfiguration().pluginsFolder).listFiles()) {
            if (f.getName().endsWith(".jar"))
                EoBot.getInstance().getPluginManager().loadPlugin(f);
        }
    }

    private static void registerShutdownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(()-> {
            if(ApplicationManager.shouldReboot)
                return;
            EoBot.getInstance().getPluginManager().callEvent(new EoBotShutdownEvent());
        }));
    }

    private static void initBot(){
        EoBot.getInstance().getPluginManager().callEvent(new DiscordLoginEvent());
        DiscordApiBuilder builder = new DiscordApiBuilder();
        builder.setToken(EoBot.getInstance().getEoBotConfiguration().discordBotToken);
        builder.addServerChannelChangeOverwrittenPermissionsListener(new AServerChannelChangeOverwrittenPermissionsListener());
        builder.addServerVoiceChannelChangeUserLimitListener(new AServerVoiceChannelChangeUserLimitListener());
        builder.addKnownCustomEmojiChangeNameListener(new AKnownCustomEmojiChangeNameListener());
        builder.addServerVoiceChannelMemberJoinListener(new AServerVoiceChannelMemberJoinListener());
        builder.addKnownCustomEmojiCreateListener(new AKnownCustomEmojiCreateListener());
        builder.addKnownCustomEmojiDeleteListener(new AKnownCustomEmojiDeleteListener());
        builder.addUserChangeDiscriminatorListener(new AUserChangeDiscriminatorListener());
        builder.addServerChangeAfkTimeoutListener(new AServerChangeAfkTimeoutListener());
        builder.addUserChangeSelfDeafenedListener(new AUserChangeSelfDeafenedListener());
        builder.addGroupChannelChangeNameListener(new AGroupChannelChangeNameListener());
        builder.addServerTextChannelChangeTopicListener(new AServerTextChannelChangeTopicListener());
        builder.addServerChannelChangeNsfwFlagListener(new AServerChannelChangeNsfwFlagListener());
        builder.addServerChangeVerificationLevelListener(new AServerChangeVerificationLevelListener());
        builder.addServerChannelChangePositionListener(new AServerChannelChangePositionListener());
        builder.addServerVoiceChannelMemberLeaveListener(new AServerVoiceChannelMemberLeaveListener());
        builder.addServerVoiceChannelChangeBitrateListener(new AServerVoiceChannelChangeBitrateListener());
        builder.addServerTextChannelChangeSlowmodeListener(new AServerTextChannelChangeSlowmodeListener());
        builder.addServerChannelChangeNameListener(new AServerChannelChangeNameListener());
        builder.addServerChangeSystemChannelListener(new AServerChangeSystemChannelListener());
        builder.addUserChangeNicknameListener(new AUserChangeNicknameListener());
        builder.addUserChangeStatusListener(new AUserChangeStatusListener());
        builder.addLostConnectionListener(new ALostConnectionListener());
        builder.addUserChangeNameListener(new AUserChangeNameListener());
        builder.addResumeListener(new AResumeListener());
        builder.addUserStartTypingListener(new AUserStartTypingListener());
        builder.addUserChangeMutedListener(new AUserChangeMutedListener());
        builder.addGroupChannelCreateListener(new AGroupChannelCreateListener());
        builder.addWebhooksUpdateListener(new AWebhooksUpdateListener());
        builder.addPrivateChannelDeleteListener(new APrivateChannelDeleteListener());
        builder.addReactionAddListener(new AReactionAddListener());
        builder.addUserChangeDeafenedListener(new AUserChangeDeafenedListener());
        builder.addReconnectListener(new AReconnectListener());
        builder.addReactionRemoveListener(new AReactionRemoveListener());
        builder.addMessageEditListener(new AMessageEditListener());
        builder.addChannelPinsUpdateListener(new AChannelPinsUpdateListener());
        builder.addMessageDeleteListener(new AMessageDeleteListener());
        builder.addMessageCreateListener(new AMessageCreateListener());
        builder.addCachedMessagePinListener(new ACachedMessagePinListener());
        builder.addRoleChangePositionListener(new ARoleChangePositionListener());
        builder.addUserRoleAddListener(new AUserRoleAddListener());
        builder.addRoleChangeMentionableListener(new ARoleChangeMentionableListener());
        builder.addRoleChangeNameListener(new ARoleChangeNameListener());
        builder.addRoleDeleteListener(new ARoleDeleteListener());
        builder.addUserRoleRemoveListener(new AUserRoleRemoveListener());
        builder.addRoleChangeHoistListener(new ARoleChangeHoistListener());
        builder.addServerJoinListener(new AServerJoinListener());
        builder.addServerChangeRegionListener(new AServerChangeRegionListener());
        builder.addRoleChangeColorListener(new ARoleChangeColorListener());
        builder.addUserChangeActivityListener(new AUserChangeActivityListener());
        builder.addServerChannelCreateListener(new AServerChannelCreateListener());
        builder.addCachedMessageUnpinListener(new ACachedMessageUnpinListener());
        builder.addUserChangeSelfMutedListener(new AUserChangeSelfMutedListener());
        builder.addServerChannelDeleteListener(new AServerChannelDeleteListener());
        builder.addRoleCreateListener(new ARoleCreateListener());
        builder.addServerChangeIconListener(new AServerChangeIconListener());
        builder.addServerChangeNameListener(new AServerChangeNameListener());
        builder.addUserChangeAvatarListener(new AUserChangeAvatarListener());
        builder.addRoleChangePermissionsListener(new ARoleChangePermissionsListener());
        builder.addServerMemberLeaveListener(new AServerMemberLeaveListener());
        builder.addGroupChannelDeleteListener(new AGroupChannelDeleteListener());
        builder.addReactionRemoveAllListener(new AReactionRemoveAllListener());
        builder.addServerMemberBanListener(new AServerMemberBanListener());
        builder.addServerMemberUnbanListener(new AServerMemberUnbanListener());
        builder.addPrivateChannelCreateListener(new APrivateChannelCreateListener());
        builder.addServerChangeMultiFactorAuthenticationLevelListener(new AServerChangeMultiFactorAuthenticationLevelListener());
        builder.addServerChangeDefaultMessageNotificationLevelListener(new AServerChangeDefaultMessageNotificationLevelListener());
        builder.addServerChangeExplicitContentFilterLevelListener(new AServerChangeExplicitContentFilterLevelListener());
        builder.addKnownCustomEmojiChangeWhitelistedRolesListener(new AKnownCustomEmojiChangeWhitelistedRolesListener());
        builder.addServerMemberJoinListener(new AServerMemberJoinListener());
        builder.addServerLeaveListener(new AServerLeaveListener());
        builder.addServerChangeSplashListener(new AServerChangeSplashListener());
        builder.addServerChangeOwnerListener(new AServerChangeOwnerListener());
        builder.addServerBecomesUnavailableListener(new AServerBecomesUnavailableListener());
        builder.addServerBecomesAvailableListener(new AServerBecomesAvailableListener());
        builder.addServerChangeAfkChannelListener(new AServerChangeAfkChannelListener());
        EoBot.getInstance().setAPI(builder.login().join());
        EoBot.getInstance().getApi().updateStatus(UserStatus.ONLINE);
        EoBot.getInstance().getApi().updateActivity(ActivityType.PLAYING, VERSION);
    }

    private static void listenCommands(){
        new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            String cmd = "";
            while (true) {
                cmd = scanner.nextLine();
                String[] arr = cmd.split(" ");
                String[] args = new String[arr.length - 1];
                System.arraycopy(arr, 1, args, 0, args.length);

                if (EoBot.getInstance().getPluginManager().isConsoleCommand(arr[0])) {
                    Logger.log("> " + cmd);
                    EoBot.getInstance().getPluginManager().getConsoleCommand(arr[0]).run(args);
                } else {
                    Logger.log("Unknown command!");
                }
            }
        }).start();
    }

    private static void initTables(){
        MySQLConnection eobot = EoBot.getInstance().getMySQLConnection("eobot");
        try {
            eobot.preparedStatement("").execute();
        } catch (SQLException e) {
            ExceptionHandler.handle(e);
        }
    }
}
