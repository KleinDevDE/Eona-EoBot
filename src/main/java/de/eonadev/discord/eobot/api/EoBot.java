package de.eonadev.discord.eobot.api;

import de.eonadev.discord.eobot.api.managers.PluginManager;
import de.eonadev.discord.eobot.utils.MySQLConnection;
import de.eonadev.discord.eobot.utils.ProdDevWorker;
import de.eonadev.discord.eobot.utils.config.EoBotConfiguration;
import org.javacord.api.DiscordApi;

import java.util.HashMap;

public class EoBot {
    private static EoBot INSTANCE;
    private DiscordApi api;
    private static PluginManager pluginManager = new PluginManager();
    private EoBotConfiguration eoBotConfiguration = new EoBotConfiguration();
    private HashMap<String, MySQLConnection> mySQLConnectionHashMap = new HashMap<>();

    public EoBot(){
        INSTANCE = this;
    }

    public void setAPI(DiscordApi api){
        this.api = api;
    }


    public static EoBot getInstance(){
        return INSTANCE;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public void reloadConfig(){
        eoBotConfiguration = new EoBotConfiguration();
    }

    public EoBotConfiguration getEoBotConfiguration() {
        return eoBotConfiguration;
    }

    public DiscordApi getApi() {
        return api;
    }

    @Deprecated
    public long getServerIDProductive() {
        return ProdDevWorker.getServerID();
    }

    @Deprecated
    public long getServerIDTest() {
        return ProdDevWorker.getServerID();
    }

    public long getServerID() {
        return ProdDevWorker.getServerID();
    }

    public void registerMySQLConnection(String name, MySQLConnection mySQLConnection) {
        this.mySQLConnectionHashMap.put(name, mySQLConnection);
    }

    public MySQLConnection getMySQLConnection(String name) {
        return mySQLConnectionHashMap.get(name);
    }
}
