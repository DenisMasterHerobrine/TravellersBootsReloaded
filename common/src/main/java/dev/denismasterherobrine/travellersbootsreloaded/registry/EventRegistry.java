package dev.denismasterherobrine.travellersbootsreloaded.registry;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded.config;

public class EventRegistry {
    static boolean isStepHeightEnabled = config.getBoolean("isStepHeightEnabled");

    static int[] speedModifiers = {
            config.getInteger("speedModifierTier1"),
            config.getInteger("speedModifierTier2"),
            config.getInteger("speedModifierTier3"),
            config.getInteger("speedModifierTier4"),
            config.getInteger("speedModifierTier5")
    };

    static int[] jumpModifiers = {
            0,
            0,
            0,
            config.getInteger("jumpModifierTier4"),
            config.getInteger("jumpModifierTier5")
    };

    public static void register() {
        Set<UUID> uuids = new HashSet<>();

        TickEvent.PLAYER_PRE.register(player -> {
            UUID uuid = player.getUUID();

            if (isStepHeightEnabled) {
                int currentBootsTier = getBootsTier(player);
                player.maxUpStep = player.isShiftKeyDown() ? 0.6f : (currentBootsTier > 1 ? 1.25f : 0.75f);

                if (currentBootsTier > 0) {
                    uuids.add(uuid);
                } else {
                    uuids.remove(uuid);
                }
            }
        });

        TickEvent.SERVER_POST.register(server -> {
            for (UUID uuid : uuids) {
                ServerPlayer player = server.getPlayerList().getPlayer(uuid);

                if (player != null) {
                    int currentBootsTier = getBootsTier(player);

                    if (currentBootsTier > 0) {
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, speedModifiers[currentBootsTier - 1]));
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1, jumpModifiers[currentBootsTier - 1]));
                    }
                }
            }
        });
    }

    private static int getBootsTier(Player player) {
        Item[] TRAVELLERS_BOOTS = {
                ItemRegistry.TRAVELLERS_BOOTS_TIER_1.get(),
                ItemRegistry.TRAVELLERS_BOOTS_TIER_2.get(),
                ItemRegistry.TRAVELLERS_BOOTS_TIER_3.get(),
                ItemRegistry.TRAVELLERS_BOOTS_TIER_4.get(),
                ItemRegistry.TRAVELLERS_BOOTS_TIER_5.get()
        };

        for (int i = 4; i >= 0; i--) {
            int finalI = i;

            if (StreamSupport.stream(player.getArmorSlots().spliterator(), false)
                    .anyMatch(itemStack -> itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS[finalI])) {
                return i + 1;
            }
        }
        return 0;
    }
}