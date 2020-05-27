package de.eonadev.discord.eobot.api.managers;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.api.events.base.Event;
import de.eonadev.discord.eobot.api.listeners.Listener;
import de.eonadev.discord.eobot.api.plugin.EoBotPlugin;
import de.eonadev.discord.eobot.api.plugin.PluginDescription;
import de.eonadev.discord.eobot.api.plugin.PluginLoadException;
import de.eonadev.discord.eobot.utils.DevTweaks;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class PluginManager {
    private static EventManager eventManager = new EventManager();
    private static HashMap<EoBotPlugin, Set<Listener>> listeners = new HashMap<>();
    private static HashMap<String, EoBotPlugin> plugins = new HashMap<>();
    private static HashMap<String, PluginDescription> pluginDescriptionHashMap = new HashMap<>();
    private static HashMap<String, String> pluginPackages = new HashMap<>();

    public void loadPlugin(File file) {
        try {
            if (!DevTweaks.isJAR(file))
                throw new PluginLoadException("File \"" + file.getName() + "\" isn't a valid jar file!");

            JarFile jarFile = new JarFile(file);
            JarEntry pluginDescriptionINI = jarFile.getJarEntry("plugin.ini");

            if(pluginDescriptionINI == null)
                throw new PluginLoadException("File \"" + file.getName() + "\" doesn't contain the plugin.ini file!");
            PluginDescription pluginDescription = new PluginDescription(jarFile.getInputStream(pluginDescriptionINI));

            if (plugins.containsKey(pluginDescription.getPluginName())){
                Logger.log("Plugin \""+pluginDescription.getPluginName()+"\" already present! Skipping..");
                return;
            }

            Logger.log("Loading plugin \"" + pluginDescription.getPluginName() + "\"..");
            URLClassLoader cl = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()});
            Class<?> c = cl.loadClass(pluginDescription.getMain());
            if (!c.getSuperclass().equals(EoBotPlugin.class))
                throw new PluginLoadException("Plugin \"" + pluginDescription.getPluginName() + "\" doesn't contain a class which extends EoBotPlugin!");
            EoBotPlugin plugin = (EoBotPlugin) c.newInstance();
            plugin.set(file, new File(EoBot.getInstance().getEoBotConfiguration().pluginsFolder + "/" + pluginDescription.getPluginName()), pluginDescription);

            String pack = EoBotPlugin.getPluginDescription().getMain().replace(
                    "." + EoBotPlugin.getPluginDescription().getMain().split("\\.")[(pluginDescription.getMain().split("\\.").length) - 1], "");
            pluginPackages.put(pluginDescription.getPluginName(), pack);
            plugins.put(pluginDescription.getPluginName().toLowerCase(), plugin);
            pluginDescriptionHashMap.put(pluginDescription.getPluginName().toLowerCase(), pluginDescription);
            Logger.log("Enabling plugin \"" + pluginDescription.getPluginName() + "\"..");
            plugin.onEnable();
            Logger.log(pluginDescription.getPluginName() + " enabled!");
        } catch (PluginLoadException | IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        }
    }

    public EoBotPlugin getPlugin(String name) {
        for(String s : plugins.keySet())
            Logger.log(LogType.DEBUG, "plugins.key -> " + s); //TODO remove DEBUG
        return plugins.get(name.toLowerCase());
    }

    public PluginDescription getPluginDescription(String name) {
        return pluginDescriptionHashMap.get(name.toLowerCase());
    }

    public void unloadPlugin(EoBotPlugin eoBotPlugin) {
        Logger.log("Unloading plugin \"" + EoBotPlugin.getPluginDescription().getPluginName() + "\"..");
        if (listeners.containsKey(eoBotPlugin)) {
            for (Listener l : listeners.get(eoBotPlugin)) {
                eventManager.unregisterListener(l);
            }
        }
        CommandManager.unregisterCommands(eoBotPlugin);
        listeners.remove(eoBotPlugin);
        eoBotPlugin.onDisable();
        plugins.remove(EoBotPlugin.getPluginDescription().getPluginName().toLowerCase());
        pluginDescriptionHashMap.remove(EoBotPlugin.getPluginDescription().getPluginName().toLowerCase());
        pluginPackages.remove(EoBotPlugin.getPluginDescription().getPluginName());
        Logger.log(EoBotPlugin.getPluginDescription().getPluginName() + " disabled!");
    }

    public Set<String> getActivePlugins() {
        return plugins.keySet();
    }

    public <T extends Event> T callEvent(T e) {
        return eventManager.callEvent(e);
    }

    public void registerListener(Listener listener) {
        eventManager.registerListener(listener);
    }

    public void unregisterListener(Listener listener){
        eventManager.unregisterListener(listener);
    }

    public void registerCommand(Command command, EoBotPlugin eoBotPlugin){
        CommandManager.registerCommand(command, eoBotPlugin);
    }

    public void registerCommand(ConsoleCommand consoleCommand){
        CommandManager.registerCommand(consoleCommand);
    }

    public void unregisterCommand(Command command, EoBotPlugin eoBotPlugin){
        CommandManager.unregisterCommand(command, eoBotPlugin);
    }

    public void unregisterCommand(ConsoleCommand consoleCommand, EoBotPlugin eoBotPlugin){
        CommandManager.unregisterCommand(consoleCommand, eoBotPlugin);
    }

    public boolean isCommand(String cmd){
        return CommandManager.isCommand(cmd);
    }

    public boolean isConsoleCommand(String cmd) {
        return CommandManager.isConsoleCommand(cmd);
    }

    public Command getCommand(String cmd) {
        return CommandManager.getCommand(cmd);
    }

    public Collection<Command> getAllDiscordCommands() {
        return CommandManager.getAllDiscordCommands();
    }

    public ConsoleCommand getConsoleCommand(String cmd) {
        return CommandManager.getConsoleCommand(cmd);
    }

    public String getPluginNameByPackage(String pack) {
        for (Map.Entry<String, String> entry : pluginPackages.entrySet()) {
            if (entry.getValue().equals(pack))
                return entry.getKey();
        }
        return "";
    }

}
