package dev.denismasterherobrine.travellersbootsreloaded.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

import static dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded.MOD_ID;
import static dev.denismasterherobrine.travellersbootsreloaded.armor.material.TravellersBootsMaterials.*;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY);

    public static RegistrySupplier<Item> TRAVELLERS_BOOTS_TIER_1 = ITEMS.register(
            "travellers_boots_tier1",
            () -> new ArmorItem(
                    TIER_1_MATERIAL,
                    EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeTabRegistry.TRAVELLERS_BOOTS_TAB).durability(16)
            )
    );

    public static RegistrySupplier<Item> TRAVELLERS_BOOTS_TIER_2 = ITEMS.register(
            "travellers_boots_tier2",
            () -> new ArmorItem(
                    TIER_2_MATERIAL,
                    EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeTabRegistry.TRAVELLERS_BOOTS_TAB).durability(32)
            )
    );

    public static RegistrySupplier<Item> TRAVELLERS_BOOTS_TIER_3 = ITEMS.register(
            "travellers_boots_tier3",
            () -> new ArmorItem(
                    TIER_3_MATERIAL,
                    EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeTabRegistry.TRAVELLERS_BOOTS_TAB).durability(64)
            )
    );

    public static RegistrySupplier<Item> TRAVELLERS_BOOTS_TIER_4 = ITEMS.register(
            "travellers_boots_tier4",
            () -> new ArmorItem(
                    TIER_4_MATERIAL,
                    EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeTabRegistry.TRAVELLERS_BOOTS_TAB).durability(128)
            )
    );

    public static RegistrySupplier<Item> TRAVELLERS_BOOTS_TIER_5 = ITEMS.register(
            "travellers_boots_tier5",
            () -> new ArmorItem(
                    TIER_5_MATERIAL,
                    EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeTabRegistry.TRAVELLERS_BOOTS_TAB).durability(256)
            )
    );

    public static void init() {
        ITEMS.register();
    }
}
