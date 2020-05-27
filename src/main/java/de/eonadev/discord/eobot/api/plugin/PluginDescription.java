package de.eonadev.discord.eobot.api.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PluginDescription {
    private String pluginName;
    private String version;
    private String[] authors;
    private String main;

    public PluginDescription(InputStream pluginIniFile){
        try {
            Properties properties = new Properties();
            properties.load(pluginIniFile);
            pluginIniFile.close();
            load(properties);
        } catch (IOException e) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        }
    }

    public PluginDescription(Properties properties){
        load(properties);
    }

    private void load(Properties properties){
        try {
            if(!properties.containsKey("name"))
                throw new PluginLoadException("plugin.ini file doesn't contain \"name\"");
            if(!properties.containsKey("version"))
                throw new PluginLoadException("plugin.ini file doesn't contain \"version\"");
            if(!properties.containsKey("authors"))
                throw new PluginLoadException("plugin.ini file doesn't contain \"authors\"");
            if(!properties.containsKey("main"))
                throw new PluginLoadException("plugin.ini file doesn't contain \"main\"");
            pluginName = properties.getProperty("name");
            version = properties.getProperty("version");
            authors = properties.getProperty("authors").replace(" ", "").split(",");
            main = properties.getProperty("main");
        }catch (PluginLoadException e) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        }
    }

    public String getPluginName() {
        return pluginName;
    }

    public String getVersion() {
        return version;
    }

    public String getMain() {
        return main;
    }

    public String[] getAuthors() {
        return authors;
    }
}
