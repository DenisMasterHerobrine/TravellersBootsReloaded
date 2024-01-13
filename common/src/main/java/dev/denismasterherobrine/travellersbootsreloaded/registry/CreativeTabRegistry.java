package dev.denismasterherobrine.travellersbootsreloaded.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static dev.denismasterherobrine.travellersbootsreloaded.registry.ItemRegistry.*;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTRY = DeferredRegister.create(TravellersBootsReloaded.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> TRAVELLERS_BOOTS_TAB = CREATIVE_TAB_REGISTRY.register("travellers_boots_creative_tab", () ->
            dev.architectury.registry.CreativeTabRegistry.create(Component.translatable("%s.creative_tab".formatted(TravellersBootsReloaded.MOD_ID)), () ->
                    new ItemStack(TRAVELLERS_BOOTS_TIER_1.get())));

    public static void init() {
        dev.architectury.registry.CreativeTabRegistry.append(TRAVELLERS_BOOTS_TAB,
                TRAVELLERS_BOOTS_TIER_1.get(),
                TRAVELLERS_BOOTS_TIER_2.get(),
                TRAVELLERS_BOOTS_TIER_3.get(),
                TRAVELLERS_BOOTS_TIER_4.get(),
                TRAVELLERS_BOOTS_TIER_5.get()
        );

        CREATIVE_TAB_REGISTRY.register();
    }
}
