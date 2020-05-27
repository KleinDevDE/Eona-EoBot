package de.eonadev.discord.eobot.api.managers;

import de.eonadev.discord.eobot.api.commands.base.Command;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.api.plugin.EoBotPlugin;
import de.eonadev.discord.eobot.api.plugin.InternalPlugin;
import de.eonadev.discord.eobot.api.plugin.PluginLoadException;
import de.eonadev.discord.eobot.utils.logging.Logger;
import org.reflections.Reflections;

import java.util.*;

public class CommandManager {
    private static HashMap<String, EoBotPlugin> pluginCommandMapping = new HashMap<>();
    private static HashMap<String, Command> discordCommands = new HashMap<>();
    private static HashMap<String, Set<String>> discordCommandAliases = new HashMap<>();

    private static HashMap<String, ConsoleCommand> consoleCommands = new HashMap<>();
    private static HashMap<String, Set<String>> consoleCommandAliases =  new HashMap<>();

    static void registerCommand(Command command, EoBotPlugin eoBotPlugin) {
        CommandInfo commandInfo = getCommandInfo(command);
        if (commandInfo == null) {
            try {
                throw new PluginLoadException("Command class \"" + command.getClass().getName() + "\" doesn't have the @CommandInfo annotation");
            } catch (PluginLoadException e) {
                e.printStackTrace();
            }
            return;
        }
        if (!discordCommands.containsKey(commandInfo.cmd())) {
            pluginCommandMapping.put(commandInfo.cmd(), eoBotPlugin);
            discordCommands.put(commandInfo.cmd().toLowerCase(), command);
            if (!discordCommandAliases.containsKey(commandInfo.cmd()))
                discordCommandAliases.put(commandInfo.cmd(), new HashSet<String>());
            for (String s : discordCommandAliases.get(commandInfo.cmd())) {
                if (isAliasAlreadyPresent(s, (byte) 1)) {
                    Logger.log("The alias \"" + s + "\" is already set! Skipping...");
                } else discordCommandAliases.get(commandInfo.cmd()).add(s);
            }
            Logger.log("Discord-Command \"" + commandInfo.cmd() + "\" registered!");
        } else Logger.log("Command \""+commandInfo.cmd()+"\" already registered1");
    }

    static void registerCommand(ConsoleCommand consoleCommand){
        CommandInfo commandInfo = getCommandInfo(consoleCommand);
        if (!consoleCommands.containsKey(commandInfo.cmd())){
            consoleCommands.put(commandInfo.cmd().toLowerCase(), consoleCommand);
            if(!consoleCommandAliases.containsKey(commandInfo.cmd()))
                consoleCommandAliases.put(commandInfo.cmd(), new HashSet<String>());
            for(String s : consoleCommandAliases.get(commandInfo.cmd())){
                if (isAliasAlreadyPresent(s, (byte) 2)){
                    Logger.log("The alias \""+s+"\" is already set! Skipping...");
                } else consoleCommandAliases.get(commandInfo.cmd()).add(s);
            }
            Logger.log("Console-Command \""+commandInfo.cmd()+"\" registered!");
        } else Logger.log("Command \""+commandInfo.cmd()+"\" already registered!");
    }

    static void unregisterCommand(Command command, EoBotPlugin eoBotPlugin){
        discordCommandAliases.remove(getCommandInfo(command).cmd().toLowerCase());
        discordCommands.remove(getCommandInfo(command).cmd().toLowerCase());
        pluginCommandMapping.remove(getCommandInfo(command).cmd().toLowerCase());
    }

    static void unregisterCommand(ConsoleCommand consoleCommand, EoBotPlugin eoBotPlugin){
        consoleCommands.remove(getCommandInfo(consoleCommand).cmd().toLowerCase());
    }

    static void unregisterCommands(EoBotPlugin eoBotPlugin){
        Set<String> strings = new HashSet<>();
        for(Map.Entry<String, EoBotPlugin> entry : pluginCommandMapping.entrySet()){
            if (entry.getValue().equals(eoBotPlugin)){
                discordCommandAliases.remove(entry.getKey().toLowerCase());
                discordCommands.remove(entry.getKey().toLowerCase());
                strings.add(entry.getKey().toLowerCase());
            }
        }
        for (String s : strings) {
            pluginCommandMapping.remove(s);
        }
    }

    public static void registerInternalCommands(){
        Reflections reflections = new Reflections("de.eonadev.discord.eobot.api.commands");
        for(Class c : reflections.getSubTypesOf(Command.class)){
            if (!c.isAnnotationPresent(CommandInfo.class))
                continue;
            try {
                registerCommand((Command) c.newInstance(), new InternalPlugin());
            } catch (InstantiationException | IllegalAccessException e) {
                Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
            }
        }

        for(Class c : reflections.getSubTypesOf(ConsoleCommand.class)){
            if (!c.isAnnotationPresent(CommandInfo.class))
                continue;
            try {
                registerCommand((ConsoleCommand) c.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
            }
        }

    }

    static Collection<Command> getAllDiscordCommands() {
        return discordCommands.values();
    }

    //TODO check for alias
    static boolean isCommand(String cmd) {
        return (discordCommands.containsKey(cmd.toLowerCase()) || isAliasAlreadyPresent(cmd, (byte) 1));
    }

    static Command getCommand(String cmd) {
        Command command = discordCommands.get(cmd.toLowerCase());
        if(command == null)
            command = (Command) getCommandByAlias(cmd, (byte) 1);
        return command;
    }

    static boolean isConsoleCommand(String cmd){
        return (consoleCommands.containsKey(cmd.toLowerCase()));
    }

    static ConsoleCommand getConsoleCommand(String cmd){
        return consoleCommands.get(cmd.toLowerCase());
    }

    private static CommandInfo getCommandInfo(Object command){
        return command.getClass().getAnnotation(CommandInfo.class);
    }

    private static CommandInfo getCommandInfo(ConsoleCommand command){
        return command.getClass().getAnnotation(CommandInfo.class);
    }

    /**
     *
     * @param alias
     * @param type 1=DiscordCommand, 2=ConsoleCommand
     * @return
     */
    private static boolean isAliasAlreadyPresent(String alias, byte type){
        if (type == 1){
            for(Map.Entry<String, Set<String>> entry : discordCommandAliases.entrySet()){
                for(String s : entry.getValue()){
                    if (alias.toLowerCase() == s)
                        return true;
                }
            }
        } else if (type == 2){
            for(Map.Entry<String, Set<String>> entry : consoleCommandAliases.entrySet()){
                for(String s : entry.getValue()){
                    if (alias.toLowerCase() == s)
                        return true;
                }
            }
        }
        return false;
    }

    private static Object getCommandByAlias(String alias, byte type){
        if (type == 1){
            for(Map.Entry<String, Set<String>> entry : discordCommandAliases.entrySet()){
                for(String s : entry.getValue()){
                    if (alias.toLowerCase() == s)
                        return discordCommands.get(s);
                }
            }
        } else if (type == 2){
            for(Map.Entry<String, Set<String>> entry : consoleCommandAliases.entrySet()){
                for(String s : entry.getValue()){
                    if (alias.toLowerCase() == s)
                        return consoleCommands.get(s);
                }
            }
        }
        return null;
    }

}
