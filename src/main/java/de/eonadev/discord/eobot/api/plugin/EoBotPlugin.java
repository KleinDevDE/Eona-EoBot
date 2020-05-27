package de.eonadev.discord.eobot.api.plugin;

import java.io.File;

public abstract class EoBotPlugin {
    private static PluginDescription pluginDescription;
    private static File dataFolder;
    private static File pluginFile;

    public static File getDataFolder() {
        dataFolder.mkdir();
        return dataFolder;
    }

    public abstract void onEnable();

    /**
     * Every listener will be automatically unregistered while disabling the plugin
     */
    public abstract void onDisable();

    public static File getPluginFile() {
        return pluginFile;
    }

    public void reload() {

    }

    public static PluginDescription getPluginDescription() {
        return pluginDescription;
    }

    public final void set(final File pluginFile, final File dataFolder, final PluginDescription pluginDescription) {
        EoBotPlugin.pluginDescription = pluginDescription;
        EoBotPlugin.dataFolder = dataFolder;
        EoBotPlugin.pluginFile = pluginFile;
    }
}
