package de.eonadev.discord.eobot.api.permissions;

public class Permission {
    private String permission;
    private String description;

    public Permission(String permission, String description){
        this.permission = permission;
        this.description = description;
    }

    public boolean hasPermission(long userID){
        return permission == "default" || true;
    }

    public String getDescription() {
        return description;
    }

    public String getPermission() {
        return permission;
    }
}
