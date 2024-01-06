package dev.denismasterherobrine.travellersbootsreloaded.armor.material;

import dev.denismasterherobrine.travellersbootsreloaded.armor.CustomArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class TravellersBootsMaterials {
    public static CustomArmorMaterial TIER_1_MATERIAL = new CustomArmorMaterial(
            "travellers_boots_tier1",
            4,
            new int[]{ 1, 0, 0, 0 },
            25,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            1f,
            0f,
            () -> Ingredient.of(Items.LEATHER)
    );

    public static CustomArmorMaterial TIER_2_MATERIAL = new CustomArmorMaterial(
            "travellers_boots_tier2",
            8,
            new int[]{ 2, 0, 0, 0 },
            25,
            SoundEvents.ARMOR_EQUIP_GOLD,
            1f,
            0f,
            () -> Ingredient.of(Items.GOLD_INGOT)
    );

    public static CustomArmorMaterial TIER_3_MATERIAL = new CustomArmorMaterial(
            "travellers_boots_tier3",
            12,
            new int[]{ 4, 0, 0, 0 },
            25,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            1f,
            0f,
            () -> Ingredient.of(Items.DIAMOND)
    );

    public static CustomArmorMaterial TIER_4_MATERIAL = new CustomArmorMaterial(
            "travellers_boots_tier4",
            16,
            new int[]{ 6, 0, 0, 0 },
            25,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            1f,
            0f,
            () -> Ingredient.of(Items.EMERALD_BLOCK)
    );

    public static CustomArmorMaterial TIER_5_MATERIAL = new CustomArmorMaterial(
            "travellers_boots_tier5",
            32,
            new int[]{ 8, 0, 0, 0 },
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            1f,
            0f,
            () -> Ingredient.of(Items.NETHERITE_SCRAP)
    );
}
