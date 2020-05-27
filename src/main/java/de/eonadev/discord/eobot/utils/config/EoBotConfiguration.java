package de.eonadev.discord.eobot.utils.config;

import de.eonadev.discord.eobot.utils.DevTweaks;

import java.io.File;

public class EoBotConfiguration extends Config {
    public EoBotConfiguration(){
        load();
    }

    @ConfigPath(path = "discord.bot-token")
    public String discordBotToken = "XXX_TOKEN_XXX";
    @ConfigPath(path = "discord.nickname")
    public String discordNickname = "EoBot";
    @ConfigPath(path = "discord.commandPrefix")
    public String commandPrefix = "!";
    @ConfigPath(path = "discord.status.type", description = "LISTENING | PLAYING | STREAMING | WATCHING")
    public String discordStatusType = "PLAYING";
    @ConfigPath(path = "discord.status.message", description = "Placeholders: %version%")
    public String discordStatusMessage = "v%version%";

    @ConfigPath(path = "socketserver.ip")
    public String socketserverIP = "10.1.1.3";
    @ConfigPath(path = "socketserver.port")
    public int socketserverPort = 5678;
    @ConfigPath(path = "socketserver.cryptoKey")
    public String socketserverCryptoKey = DevTweaks.randomAlphaNumeric(10, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvw1234567890");

    @ConfigPath(path = "application.debug")
    public boolean debug = false;
    @ConfigPath(path = "application.pluginsFolder")
    public String pluginsFolder = "plugins";
    @ConfigPath(path = "application.logsFolder")
    public String logsFolder = "logs";

    @Override
    public File getFile() {
        return new File("config.yml");
    }
}
