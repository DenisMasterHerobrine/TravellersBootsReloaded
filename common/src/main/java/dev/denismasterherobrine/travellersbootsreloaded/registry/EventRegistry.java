package dev.denismasterherobrine.travellersbootsreloaded.registry;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static dev.denismasterherobrine.travellersbootsreloaded.registry.ItemRegistry.*;

public class EventRegistry {
    public static void register() {
        AtomicReference<UUID> uuid = new AtomicReference<>();

        TickEvent.PLAYER_PRE.register(
                (player) -> {
                    uuid.set(player.getUUID());
                }
        );

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
                                case 1: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 0));
                                    break;
                                }

                                case 2: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 0));
                                    player.maxUpStep = 1.0f;
                                    break;
                                }

                                case 3: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 1));
                                    player.maxUpStep = 1.0f;
                                    break;
                                }

                                case 4: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 2));
                                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1, 1));
                                    player.maxUpStep = 1.0f;
                                    break;
                                }

                                case 5: {
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 3));
                                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1, 1));
                                    player.maxUpStep = 1.0f;
                                    break;
                                }
                            }
                        }
                    }
                }
        );

    }
}
