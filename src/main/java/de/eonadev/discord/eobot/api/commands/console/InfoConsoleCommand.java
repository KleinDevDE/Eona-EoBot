package de.eonadev.discord.eobot.api.commands.console;

import de.eonadev.discord.eobot.Main;
import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.api.commands.base.CommandInfo;
import de.eonadev.discord.eobot.api.commands.base.ConsoleCommand;
import de.eonadev.discord.eobot.api.plugin.PluginDescription;
import de.eonadev.discord.eobot.utils.logging.LogType;
import de.eonadev.discord.eobot.utils.logging.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CommandInfo(cmd = "info")
public class InfoConsoleCommand extends ConsoleCommand {
    @Override
    public void run(String[] args) {
        List<List<String>> rows = new ArrayList<>();


        for (String s : EoBot.getInstance().getPluginManager().getActivePlugins()) {
            PluginDescription pd = EoBot.getInstance().getPluginManager().getPluginDescription(s);
            rows.add(Arrays.asList(pd.getPluginName(), Arrays.toString(pd.getAuthors()).replace("[", "").replace("]", ""), pd.getVersion()));
        }

        Logger.log(LogType.INFO, "\n" +
                "==========================\n" +
                "           EoBot\n" +
                "   written by KleinDev\n" +
                "         ---------\n" +
                "           v" + Main.VERSION + "\n" +
                "\n" +
                "Plugins: (" + EoBot.getInstance().getPluginManager().getActivePlugins().size() + ")\n" +
                formatAsTable(rows));

    }

    public String formatAsTable(List<List<String>> rows) {
        int[] maxLengths = new int[rows.get(0).size()];
        for (List<String> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
            }
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int maxLength : maxLengths) {
            formatBuilder.append("%-").append(maxLength + 3).append("s");
        }
        String format = formatBuilder.toString();

        StringBuilder result = new StringBuilder();
        for (List<String> row : rows) {
            result.append(String.format(format, row.toArray(new String[0]))).append("\n");
        }
        return result.toString();
    }

}
