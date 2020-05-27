package de.eonadev.discord.eobot.utils.tools;

import org.reflections.Reflections;

import java.util.Set;

public class ClassTools {
    public static Set<Class<?>> getClassesFromPackage(String pkg) {
        return new Reflections(pkg).getSubTypesOf(Object.class);
    }

    public static Set<Class> getClassesFromPackage(String pkg, Class subType) {
        return new Reflections(pkg).getSubTypesOf(subType);
    }
}
