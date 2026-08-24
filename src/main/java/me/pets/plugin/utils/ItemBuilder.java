package me.pets.plugin.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta meta;
    private final List<Component> lore = new ArrayList<>();

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
        this.meta = item.getItemMeta();
    }

    public ItemBuilder name(Component name) {
        meta.displayName(name);
        return this;
    }

    public ItemBuilder lore(Component line) {
        lore.add(line);
        return this;
    }

    public ItemBuilder lore(List<Component> lines) {
        lore.addAll(lines);
        return this;
    }

    public ItemStack build() {
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemMeta getMeta() {
        return meta;
    }

    public ItemStack getItem() {
        return item;
    }
}
