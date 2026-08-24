package me.pets.plugin.models;

import java.util.UUID;

public class ActivePet {

    private final UUID playerId;
    private final PetType type;
    private final Rarity rarity;
    private final boolean primary;

    public ActivePet(UUID playerId, PetType type, Rarity rarity, boolean primary) {
        this.playerId = playerId;
        this.type = type;
        this.rarity = rarity;
        this.primary = primary;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public PetType getType() {
        return type;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public boolean isPrimary() {
        return primary;
    }
}
