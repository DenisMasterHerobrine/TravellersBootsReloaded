package dev.denismasterherobrine.travellersbootsreloaded.neoforge;

import dev.denismasterherobrine.travellersbootsreloaded.TravellersBootsReloaded;
import net.neoforged.fml.common.Mod;

@Mod(TravellersBootsReloaded.MOD_ID)
public class TravellersBootsReloadedNeoForge {
    public TravellersBootsReloadedNeoForge() {
        System.out.println("Hello NeoForge!");
        TravellersBootsReloaded.init();
    }
}