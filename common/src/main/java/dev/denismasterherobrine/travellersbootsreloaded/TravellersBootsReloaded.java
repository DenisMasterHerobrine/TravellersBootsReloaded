package dev.denismasterherobrine.travellersbootsreloaded;

import dev.denismasterherobrine.travellersbootsreloaded.registry.EventRegistry;
import dev.denismasterherobrine.travellersbootsreloaded.registry.ItemRegistry;

public class TravellersBootsReloaded {
	public static final String MOD_ID = "travellersboots";

	public static void init() {
		ItemRegistry.init();
		EventRegistry.register();
	}
}
