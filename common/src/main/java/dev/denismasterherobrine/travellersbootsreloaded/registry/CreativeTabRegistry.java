package dev.denismasterherobrine.travellersbootsreloaded.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded.MOD_ID;
import static dev.denismasterherobrine.travellersbootsreloaded.registry.ItemRegistry.TRAVELLERS_BOOTS_TIER_5;

public class CreativeTabRegistry {
    public static final CreativeModeTab TRAVELLERS_BOOTS_TAB = dev.architectury.registry.CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "creative_tab"), () ->
            new ItemStack(TRAVELLERS_BOOTS_TIER_5.get()));
}
