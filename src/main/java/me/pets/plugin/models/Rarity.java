package me.pets.plugin.models;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;

public enum Rarity {

    REGULAR("Regular", NamedTextColor.WHITE, ChatColor.WHITE, 1.0),
    GOLD("Gold", NamedTextColor.GOLD, ChatColor.GOLD, 1.25),
    RAINBOW("Rainbow", TextColor.color(0xFF55FF), ChatColor.LIGHT_PURPLE, 1.5),
    SHINY("Shiny", NamedTextColor.AQUA, ChatColor.AQUA, 1.75);

    private final String displayName;
    private final TextColor color;
    private final ChatColor legacyColor;
    private final double multiplier;

    Rarity(String displayName, TextColor color, ChatColor legacyColor, double multiplier) {
        this.displayName = displayName;
        this.color = color;
        this.legacyColor = legacyColor;
        this.multiplier = multiplier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public TextColor getColor() {
        return color;
    }

    public ChatColor getLegacyColor() {
        return legacyColor;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public Component getStyledName() {
        return Component.text(displayName)
                .color(color)
                .decorate(TextDecoration.BOLD);
    }

    public static Rarity fromString(String input) {
        if (input == null) return null;
        for (Rarity rarity : values()) {
            if (rarity.name().equalsIgnoreCase(input) || rarity.displayName.equalsIgnoreCase(input)) {
                return rarity;
            }
        }
        return null;
    }
}
