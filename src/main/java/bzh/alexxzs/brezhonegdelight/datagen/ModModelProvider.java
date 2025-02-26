package bzh.alexxzs.brezhonegdelight.datagen;

import bzh.alexxzs.brezhonegdelight.block.custom.BuckwheatCrop;
import bzh.alexxzs.brezhonegdelight.block.custom.ModBlocks;
import bzh.alexxzs.brezhonegdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

import java.util.List;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.BUCKWHEAT_CROP, BuckwheatCrop.AGE, 0, 1, 2, 3, 4, 5, 6);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        List<Item> applicableList = ModItems.items;
        applicableList.remove(ModItems.BUCKWHEAT_GRAIN);

        for (Item item : applicableList)
            itemModelGenerator.register(item, Models.GENERATED);

    }
}
