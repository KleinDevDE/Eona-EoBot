package de.eonadev.discord.eobot.utils.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigPath {

	String path();
	String description() default "";
	String[] mappings() default {};
	
}
