package bzh.alexxzs.brezhonegdelight.block.custom;

import bzh.alexxzs.brezhonegdelight.BrezhonegDelight;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final Block BUCKWHEAT_CROP = registerBlock("buckwheat_crop",
            new BuckwheatCrop(AbstractBlock.Settings.create().noCollision().ticksRandomly()
                    .breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.DARK_GREEN)), false);

    public static Block registerBlock(String name, Block block, boolean doRegisterItem) {
        if (doRegisterItem) registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BrezhonegDelight.MOD_ID, name), block);

    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.BLOCK, Identifier.of(BrezhonegDelight.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        List<Item> blocks = new ArrayList<>(List.of());

        BrezhonegDelight.LOGGER.info("Registering mod blocks for " + BrezhonegDelight.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            blocks.forEach(entries::add);
        });
    }
}
