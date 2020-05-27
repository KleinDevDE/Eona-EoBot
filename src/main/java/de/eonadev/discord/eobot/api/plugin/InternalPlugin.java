package de.eonadev.discord.eobot.api.plugin;


import de.eonadev.discord.eobot.Main;

import java.io.File;
import java.util.Properties;

public class InternalPlugin extends EoBotPlugin {
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public InternalPlugin(){
        Properties properties = new Properties();
        properties.setProperty("name", "Internal");
        properties.setProperty("version", Main.VERSION);
        properties.setProperty("main", Main.class.getName());
        properties.setProperty("authors", "KleinDev");

        set(new File("./"), new File("./"), new PluginDescription(properties));
    }
}
