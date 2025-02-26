package bzh.alexxzs.brezhonegdelight.item.custom;

import bzh.alexxzs.brezhonegdelight.BrezhonegDelight;
import bzh.alexxzs.brezhonegdelight.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup BREZHONEG_DELIGHT_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BrezhonegDelight.MOD_ID, "brezhonegdelight_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BRETON_CREPE))
                    .displayName(Text.translatable("itemgroup.brezhonegdelight.bditems"))
                    .entries((displayContext, entries) -> {
                        for (Item item : ModItems.items)
                            entries.add(item);
                    }).build());
}
