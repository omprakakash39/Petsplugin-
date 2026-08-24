package me.pets.plugin.models;

public enum PetType {

    WOLF("Wolf Pet", true, "Attack Boost", 8.0),
    GOLEM("Golem Pet", true, "Damage Reduction", 4.0),
    WITCH("Witch Pet", true, "Alchemist", 10.0),
    SKELETON("Skeleton Pet", false, "Sharpshooter", 10.0),
    VILLAGER("Villager Pet", false, "Trade Master", 2.0),
    SILVERFISH("Silverfish Pet", false, "Rich Veins", 10.0),
    CREEPER("Creeper Pet", false, "Blast Proof", 5.0),
    TOTEM("Totem Pet", false, "Second Chance", 10.0),
    ENDERMAN("Enderman Pet", false, "Phase Shift", 10.0),
    WITHER_SKELETON("Wither Skeleton Pet", false, "Withering Strike", 1.0),
    BANKER("Banker Pet", false, "Golden Touch", 5.0),
    PIG("Pig Pet", false, "Pork Power", 0.5);

    private final String displayName;
    private final boolean primary;
    private final String abilityName;
    private final double baseValue;

    PetType(String displayName, boolean primary, String abilityName, double baseValue) {
        this.displayName = displayName;
        this.primary = primary;
        this.abilityName = abilityName;
        this.baseValue = baseValue;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isPrimary() {
        return primary;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public double getValue(Rarity rarity) {
        return baseValue * rarity.getMultiplier();
    }
}
