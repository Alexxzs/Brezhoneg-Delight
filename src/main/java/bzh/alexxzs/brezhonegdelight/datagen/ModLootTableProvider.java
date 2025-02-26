package bzh.alexxzs.brezhonegdelight.datagen;

import bzh.alexxzs.brezhonegdelight.block.custom.BuckwheatCrop;
import bzh.alexxzs.brezhonegdelight.block.custom.ModBlocks;
import bzh.alexxzs.brezhonegdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        dropBuckwheatCrop();

    }


    private void dropBuckwheatCrop() {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.BUCKWHEAT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BuckwheatCrop.AGE, BuckwheatCrop.MAX_AGE));

        LootPool.Builder lootPool = LootPool.builder()
                .conditionally(builder)
                .with(ItemEntry.builder(ModItems.BUCKWHEAT_GRAIN)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 4.0F)))
                );

        addDrop(ModBlocks.BUCKWHEAT_CROP, (block -> LootTable.builder().pool(lootPool)));

    }


}
