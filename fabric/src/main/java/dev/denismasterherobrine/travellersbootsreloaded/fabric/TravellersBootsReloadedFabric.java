package dev.denismasterherobrine.travellersbootsreloaded.fabric;

import dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded;
import net.fabricmc.api.ModInitializer;

public class TravellersBootsReloadedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TravellersBootsReloaded.init();
    }
}