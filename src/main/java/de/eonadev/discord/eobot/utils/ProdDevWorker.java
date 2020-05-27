package de.eonadev.discord.eobot.utils;

import com.google.gson.Gson;
import de.eonadev.discord.eobot.api.EoBot;
import de.eonadev.discord.eobot.utils.mappings.Mapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProdDevWorker {
    private static int type = EoBot.getInstance().getEoBotConfiguration().discordBotToken.endsWith("JabE") ? 0 : (EoBot.getInstance().getEoBotConfiguration().discordBotToken.endsWith("NHrw") ? 1 : -1);
    private static Mapping mapping;

    static {
        try {
            mapping = new Gson().fromJson(new FileReader(new File("mappings.json")), Mapping.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static long getServerID() {
        if (type == 0) // DEV
            return 668777998148698113L;
        else if (type == 1) // PROD
            return 537362264869568533L;
        else return 0L;
    }

    /**
     * This returns if bot is on dev or prod server active
     * 0 = dev
     * 1 = prod
     *
     * @return
     */
    public static int getRuntimeType() {
        return type;
    }

    public static long getChannelID(long id) {
        if (type == 0)
            return mapping.channels.get(id);
        else return id;
    }

    public static long getRoleID(long id) {
        if (type == 0)
            return mapping.roles.get(id);
        else return id;
    }
}
