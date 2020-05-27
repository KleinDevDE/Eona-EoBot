package de.eonadev.discord.eobot.api.commands.base;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {
    String cmd();
    String permission() default "default";
    String description() default "No description provided";
    String[] aliases() default {};
}
