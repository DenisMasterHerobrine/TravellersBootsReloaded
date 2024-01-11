package dev.denismasterherobrine.travellersbootsreloaded.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TravellersBootsReloaded.MOD_ID)
public class TravellersBootsReloadedForge {
    public TravellersBootsReloadedForge() {
		// Submit our event bus to let architectury register our content on the right time.
        EventBuses.registerModEventBus(TravellersBootsReloaded.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        TravellersBootsReloaded.init();
    }
}