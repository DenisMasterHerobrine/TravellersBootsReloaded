package dev.denismasterherobrine.travellersbootsreloaded.registry;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded.config;
import static dev.denismasterherobrine.travellersbootsreloaded.registry.ItemRegistry.*;

public class EventRegistry {
    static boolean isStepHeightEnabled = config.getBoolean("isStepHeightEnabled");

    static int speedModifierTier1 = config.getInteger("speedModifierTier1");
    static int speedModifierTier2 = config.getInteger("speedModifierTier2");
    static int speedModifierTier3 = config.getInteger("speedModifierTier3");
    static int speedModifierTier4 = config.getInteger("speedModifierTier4");
    static int speedModifierTier5 = config.getInteger("speedModifierTier5");

    static int jumpModifierTier4 = config.getInteger("jumpModifierTier4");
    static int jumpModifierTier5 = config.getInteger("jumpModifierTier5");

    public static void register() {
        AtomicReference<UUID> uuid = new AtomicReference<>();

        // Update the height on the client and give the player UUID to SERVER_POST.
        TickEvent.PLAYER_PRE.register(
                (player) -> {
                    uuid.set(player.getUUID());

                    if (isStepHeightEnabled) {
                        AtomicInteger currentBootsTier = new AtomicInteger(0);

                        player.getArmorSlots().forEach(itemStack -> {
                            if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_1.get()) {
                                currentBootsTier.set(1);
                            }

                            if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_2.get()) {
                                currentBootsTier.set(2);
                            }

                            if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_3.get()) {
                                currentBootsTier.set(3);
                            }

                            if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_4.get()) {
                                currentBootsTier.set(4);
                            }

                            if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_5.get()) {
                                currentBootsTier.set(5);
                            }
                        });

                        switch (currentBootsTier.getPlain()) {
                            case 0, 1: {
                                if (player.isShiftKeyDown()) {
                                    player.setMaxUpStep(0.6f);
                                    player.maxUpStep();
                                } else {
                                    player.setMaxUpStep(0.75f);
                                    player.maxUpStep();
                                }
                                break;
                            }

                            case 2, 3, 4, 5: {
                                if (player.isShiftKeyDown()) {
                                    player.setMaxUpStep(0.6f);
                                    player.maxUpStep();
                                } else {
                                    player.setMaxUpStep(1.25f);
                                    player.maxUpStep();
                                }
                                break;
                            }
                        }
                    }
                }
        );

        // Update the same to the server and apply the effects on SERVER_POST side.
        TickEvent.SERVER_POST.register(
                (server) -> {
                    if (uuid.get() != null) {
                        ServerPlayer player = server.getPlayerList().getPlayer(uuid.get());

                        if (player != null) {
                            AtomicInteger currentBootsTier = new AtomicInteger(0);

                            player.getArmorSlots().forEach(itemStack -> {
                                if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_1.get()) {
                                    currentBootsTier.set(1);
                                }

                                if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_2.get()) {
                                    currentBootsTier.set(2);
                                }

                                if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_3.get()) {
                                    currentBootsTier.set(3);
                                }

                                if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_4.get()) {
                                    currentBootsTier.set(4);
                                }

                                if (itemStack.getItem().getDefaultInstance().getItem() == TRAVELLERS_BOOTS_TIER_5.get()) {
                                    currentBootsTier.set(5);
                                }
                            });

                            switch (currentBootsTier.getPlain()) {
                                case 0: {
                                    break;
                                }

                                case 1: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, speedModifierTier1));

                                    break;
                                }

                                case 2: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, speedModifierTier2));

                                    break;
                                }

                                case 3: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, speedModifierTier3));

                                    break;
                                }

                                case 4: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, speedModifierTier4));
                                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1, jumpModifierTier4));

                                    break;
                                }

                                case 5: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, speedModifierTier5));
                                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1, jumpModifierTier5));

                                    break;
                                }
                            }
                        }
                    }
                }
        );
    }
}
