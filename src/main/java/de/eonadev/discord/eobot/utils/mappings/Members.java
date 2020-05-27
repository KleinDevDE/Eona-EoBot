package de.eonadev.discord.eobot.utils.mappings;

public enum Members {
    KLEINDEV(221313993321480192L),
    ALAMBE94(556571759864709133L),
    BLOODRAYNE1995(234009861099094017L),
    SIRMASTERO(541693304044126247L),
    SIVEN4(414887540131364875L);

    private long id;

    Members(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
