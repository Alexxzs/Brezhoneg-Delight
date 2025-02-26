package bzh.alexxzs.brezhonegdelight.item;

import bzh.alexxzs.brezhonegdelight.BrezhonegDelight;
import bzh.alexxzs.brezhonegdelight.block.custom.ModBlocks;
import bzh.alexxzs.brezhonegdelight.item.custom.DrinkItem;
import bzh.alexxzs.brezhonegdelight.item.custom.EdibleItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModItems {

    //Reminder: if adding a furnace recipe, rewrite furnace mixin.

    /* TODO:
        Far breton, -->
        Sablé breton, --> beurre(aj) + oeuf(v) + sucre(v) + blé(v)
        caramel au beurre salé, --> sucre(v) + beurre(aj) + sel(aj)
        gavottes, pas sûr de l'ajout
        moules frites ??? VRMT Pas sûr de l'ajout
        ajouter blé noir en tant que crop !!
         */

    public static final Item KOUIGN_AMANN = registerItem("kouign_amann",
            new EdibleItem(new Item.Settings().food(ModFoodComponents.KOUIGN_AMANN).maxCount(1), "kouign_amann"));

    public static final Item KIG_HA_FARZ = registerItem("kig_ha_farz",
            new EdibleItem(new Item.Settings().food(ModFoodComponents.KIG_HA_FARZ).maxCount(16), "kig_ha_farz"));

    public static final Item CHOUCHEN = registerItem("chouchen",
            new DrinkItem(new Item.Settings().food(ModFoodComponents.CHOUCHEN).maxCount(16), "chouchen"));

    public static final Item BRETON_CREPE = registerItem("breton_crepe",
            new EdibleItem(new Item.Settings().food(ModFoodComponents.BRETON_CREPE), "breton_crepe"));

    public static final Item SALT = registerItem("salt",
            new Item(new Item.Settings()));

    public static final Item SEMI_SALTED_BUTTER = registerItem("semi_salted_butter",
            new Item(new Item.Settings()));

    public static final Item BUCKWHEAT_GRAIN = registerItem("buckwheat_grain",
            new AliasedBlockItem(ModBlocks.BUCKWHEAT_CROP, new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BrezhonegDelight.MOD_ID, name), item);
    }

    public static List<Item> items = new ArrayList<>(Arrays.asList(KOUIGN_AMANN, KIG_HA_FARZ, CHOUCHEN, SALT,
            SEMI_SALTED_BUTTER, BRETON_CREPE, BUCKWHEAT_GRAIN));

    public static void registerModItems() {

        BrezhonegDelight.LOGGER.info("Registering mod items for " + BrezhonegDelight.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            items.forEach(entries::add);
        });
    }

}
