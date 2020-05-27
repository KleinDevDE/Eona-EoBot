package de.eonadev.discord.eobot.utils.logging;

import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.utils.DiscardingQueue;
import de.eonadev.discord.eobot.utils.StackTraceHelper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    static BufferedWriter output;
    static SimpleDateFormat FORMAT = new SimpleDateFormat("[HH:mm:ss]");
    static DiscardingQueue<String> lastLogs = new DiscardingQueue<>(30);

    public Logger(File logFolder) {
        try {
            if (!logFolder.exists())
                logFolder.mkdirs();

            File latest_log = new File(logFolder, "latest.log");
            if (latest_log.exists()) {
                BasicFileAttributes attr = Files.readAttributes(latest_log.toPath(), BasicFileAttributes.class);
                String date = new SimpleDateFormat("dd.MM.yyyy_HH-mm-ss").format(attr.creationTime().toMillis());
                int count = 0;
                File f = new File(logFolder, date + ".log");
                while (f.exists()) {
                    f = new File(logFolder, date + "-" + ++count + ".log");
                }
                Files.move(latest_log.toPath(), f.toPath());
                new File(logFolder, "latest.log").createNewFile();
                output = new BufferedWriter(new FileWriter(new File(logFolder, "latest.log"), true));
            } else {
                latest_log.createNewFile();
                output = new BufferedWriter(new FileWriter(new File(logFolder, "latest.log"), true));
            }
        } catch (IOException e) {
            Thread.currentThread().getThreadGroup().uncaughtException(Thread.currentThread(), e);
        }
    }

    public static void log(String message, boolean print) {
        log(LogType.INFO, message, print);
    }

    public static void log(String message) {
        log(LogType.INFO, message, true);
    }

    public static void log(LogType logType, String message) {
        log(logType, message, true);
    }

    public static void log(LogType logType, String message, boolean print) {
        String prePrefix = EoBot.getInstance().getPluginManager().getPluginNameByPackage(getPackage());
        if (!prePrefix.equals(""))
            prePrefix = "[" + prePrefix + "] ";
        String prefix = prePrefix;
        //TODO Check if noConsole was supplied as argument
        // if yes, set print to false
        if (logType == LogType.INFO) {
            if (print)
                print(FORMAT.format(new Date()) + TextColor.CYAN + " INFO" +TextColor.RESET + "     | " + prefix + message + TextColor.RESET);
            _log(FORMAT.format(new Date()) + " INFO     | " + prefix + message);
        } else if (logType == LogType.ERROR) {
            if (print) {
                if (isColored())
                    print(FORMAT.format(new Date()) + TextColor.RED + " ERROR"+TextColor.RESET+"    | " + TextColor.RED + prefix + message + TextColor.RESET);
                else print(FORMAT.format(new Date()) + " ERROR    | " + prefix + message);
            }
            _log(FORMAT.format(new Date()) + " ERROR    | " + prefix + message);
        } else if (logType == LogType.UPDATE) {
            if (print) {
                if (isColored())
                    print(FORMAT.format(new Date()) + TextColor.PURPLE + " UPDATE"+TextColor.RESET+"   | " + TextColor.PURPLE +  prefix + message + TextColor.RESET);
                else print(FORMAT.format(new Date()) + " UPDATE   | " + prefix + message);
            }
            _log(FORMAT.format(new Date()) + " UPDATE   | " + prefix + message);
        } else if (logType == LogType.FATAL) {
            if (print) {
                if (isColored())
                    print(FORMAT.format(new Date()) + TextColor.RED_BACKGROUND + " !FATAL!  | " + prefix + message + TextColor.RESET);
                else print(FORMAT.format(new Date()) + " !FATAL!  | " + prefix + message);
            }
            _log(FORMAT.format(new Date()) + " !FATAL!  | " + prefix + message);
        } else if (logType == LogType.DEBUG) {
            //TODO check if debugging is enabled for specific plugin
            if (print) {
                if (isColored())
                    print(FORMAT.format(new Date()) + TextColor.GREEN + " DEBUG"+TextColor.RESET+"    | " + TextColor.GREEN + prefix + message + TextColor.RESET);
                else print(FORMAT.format(new Date()) + " DEBUG    | " + prefix + message);
            }
            _log(FORMAT.format(new Date()) + " DEBUG    | " + prefix + message);
        } else if (logType == LogType.RAW) {
            if (print)
                print(FORMAT.format(new Date()) + " " + prefix + message);
            _log(FORMAT.format(new Date()) + " " + prefix + message);
        } else if (logType == LogType.WARNING) {
            if (print) {
                if (isColored())
                    print(FORMAT.format(new Date()) + TextColor.YELLOW + " WARNING"+TextColor.RESET+"  | " + TextColor.YELLOW + prefix + message + TextColor.RESET);
                else print(FORMAT.format(new Date()) + " WARNING  | " + prefix + message);
            }
            _log(FORMAT.format(new Date()) + " WARNING  | " + prefix + message);
        }

    }

    private static void _log(String message) {
        try {
            lastLogs.add(message);
            output.write(message);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            Thread.currentThread().getThreadGroup().uncaughtException(Thread.currentThread(), e);
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static String getPackage() {
//        int count = -1;
//        List<StackTraceHelper.ConstructedStackTraceElement> constructedStackTraceElement = StackTraceHelper.getElements(Thread.currentThread().getStackTrace());
//        for(StackTraceHelper.ConstructedStackTraceElement c : constructedStackTraceElement)
//            _log(count++ + c.packageName);
        return StackTraceHelper.getElements(Thread.currentThread().getStackTrace()).get(4).packageName;
    }

    private static boolean isColored() {
        //TODO check colored parameter
        return !System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static DiscardingQueue<String> getLastLogs() {
        return lastLogs;
    }
}
