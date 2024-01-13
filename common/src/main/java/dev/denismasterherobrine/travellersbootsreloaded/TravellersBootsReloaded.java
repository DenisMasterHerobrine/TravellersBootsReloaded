package dev.denismasterherobrine.travellersbootsreloaded;

import dev.denismasterherobrine.travellersbootsreloaded.config.ArchConfiguration;
import dev.denismasterherobrine.travellersbootsreloaded.registry.CreativeTabRegistry;
import dev.denismasterherobrine.travellersbootsreloaded.registry.EventRegistry;
import dev.denismasterherobrine.travellersbootsreloaded.registry.ItemRegistry;

public class TravellersBootsReloaded {
	public static final String MOD_ID = "travellersbootsreloaded";
	public static ArchConfiguration config = new ArchConfiguration("travellersbootsreloaded.properties");

	public static void init() {
		ItemRegistry.init();
		CreativeTabRegistry.init();
		EventRegistry.register();
	}
}
