package bzh.alexxzs.brezhonegdelight.item;

import bzh.alexxzs.brezhonegdelight.BrezhonegDelight;
import bzh.alexxzs.brezhonegdelight.item.custom.DrinkItem;
import bzh.alexxzs.brezhonegdelight.item.custom.EdibleItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final Item KOUIGN_AMANN = registerItem("kouign_amann", new EdibleItem(new Item.Settings().food(ModFoodComponents.KOUIGN_AMANN), "kouign_amann"));
    // TODO : k-a fait de beurre(ajouter? --> lait et [sel --> seau d'eau à évaporer]), sucre(v), pate (fd)
    public static final Item KIG_HA_FARZ = registerItem("kig_ha_farz", new EdibleItem(new Item.Settings().food(ModFoodComponents.KIG_HA_FARZ), "kig_ha_farz"));
    // TODO : k-h-f fait de porc (raw, fd), de boeuf (minced, fd), de carottes (v), d'oignon (fd), de sel (aj), d'eau (v)
    public static final Item CHOUCHEN = registerItem("chouchen", new DrinkItem(new Item.Settings().food(ModFoodComponents.CHOUCHEN), "chouchen"));
    /* TODO: Crêpes blé noir, -->
        Far breton, -->
        Sablé breton, --> beurre(aj) + oeuf(v) + sucre(v) + blé(v)
        caramel au beurre salé, --> sucre(v) + beurre(aj) + sel(aj)
        cidre? (il y a déjà dans FD...),
        paris-brest, pas sûr de l'ajout
        gavottes, pas sûr de l'ajout
        moules frites ??? VRMT Pas sûr de l'ajout
        beurre demi-sel serait drôle --> oui
         */

    public static final Item SALT = registerItem("salt", new Item(new Item.Settings()));
    public static final Item SEMI_SALTED_BUTTER = registerItem("semi_salted_butter", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BrezhonegDelight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        List<Item> items = new ArrayList<>(List.of(KOUIGN_AMANN, KIG_HA_FARZ, CHOUCHEN, SALT, SEMI_SALTED_BUTTER));

        BrezhonegDelight.LOGGER.info("Registering mod items for " + BrezhonegDelight.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            items.forEach(entries::add);
        });
    }

}
