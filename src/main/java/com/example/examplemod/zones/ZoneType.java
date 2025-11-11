package com.example.examplemod.zones;

public enum ZoneType {
    SPAWN(0, "Spawn Zone", false, false),
    GREEN(1, "Green Zone", false, false),
    YELLOW(2, "Yellow Zone", false, false),
    RED(3, "Red Zone", true, false),
    BLACK(4, "Black Zone", true, true);

    private final int level;
    private final String displayName;
    private final boolean pvpEnabled;
    private final boolean alwaysPvp;

    ZoneType(int level, String displayName, boolean pvpEnabled, boolean alwaysPvp) {
        this.level = level;
        this.displayName = displayName;
        this.pvpEnabled = pvpEnabled;
        this.alwaysPvp = alwaysPvp;
    }

    public int getLevel() {
        return level;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isPvpEnabled() {
        return pvpEnabled;
    }

    public boolean isAlwaysPvp() {
        return alwaysPvp;
    }
}
