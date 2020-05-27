package de.eonadev.discord.eobot.utils;

import de.eonadev.discord.eobot.utils.logging.Logger;

import java.security.Permission;

public class SecurityManagement extends SecurityManager {
    @Override
    public void checkDelete(String file) {
        Logger.log("SecurityManagement -> checkDelete: " + file);
    }

    @Override
    public void checkPermission(Permission perm) {
        if (perm instanceof RuntimePermission) {
            if (perm.getName().equalsIgnoreCase("setSecurityManager")) {
                throw new SecurityException("Somebody tried to re-set the SecurityManager!");
            }
        }
    }

    private boolean checkRestricted() {
        Class<?>[] context = getClassContext();
        for (int i = 2; i < context.length; i++) {
            ClassLoader loader = context[i].getClassLoader();
            if (loader == ClassLoader.getSystemClassLoader()) {
                break;
            }
            if (loader == null) continue;
            return true;
        }
        return false;
    }
}
