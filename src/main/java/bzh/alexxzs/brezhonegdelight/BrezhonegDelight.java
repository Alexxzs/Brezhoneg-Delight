package bzh.alexxzs.brezhonegdelight;

import bzh.alexxzs.brezhonegdelight.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrezhonegDelight implements ModInitializer {
	public static final String MOD_ID = "brezhonegdelight";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		LOGGER.info("Brezhoneg Delight mod initialized, Degemer mat!");
	}
}