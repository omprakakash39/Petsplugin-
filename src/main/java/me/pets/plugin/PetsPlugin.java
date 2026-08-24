package me.pets.plugin;

import me.pets.plugin.commands.PetEggCommand;
import me.pets.plugin.commands.PetsCommand;
import me.pets.plugin.listeners.AbilityListener;
import me.pets.plugin.listeners.InventoryListener;
import me.pets.plugin.listeners.PlayerInteractListener;
import me.pets.plugin.managers.AbilityManager;
import me.pets.plugin.managers.FusionManager;
import me.pets.plugin.managers.PetManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PetsPlugin extends JavaPlugin {

    private static PetsPlugin instance;
    private PetManager petManager;
    private FusionManager fusionManager;
    private AbilityManager abilityManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.petManager = new PetManager(this);
        this.fusionManager = new FusionManager(this);
        this.abilityManager = new AbilityManager(this);

        getCommand("pets").setExecutor(new PetsCommand(this));
        getCommand("petegg").setExecutor(new PetEggCommand(this));

        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getServer().getPluginManager().registerEvents(new AbilityListener(this), this);

        getLogger().info("PetsPlugin enabled successfully for 1.21.3!");
    }

    @Override
    public void onDisable() {
        if (petManager != null) {
            petManager.despawnAllVisualPets();
        }
        getLogger().info("PetsPlugin disabled.");
    }

    public static PetsPlugin getInstance() {
        return instance;
    }

    public PetManager getPetManager() {
        return petManager;
    }

    public FusionManager getFusionManager() {
        return fusionManager;
    }

    public AbilityManager getAbilityManager() {
        return abilityManager;
    }
}
