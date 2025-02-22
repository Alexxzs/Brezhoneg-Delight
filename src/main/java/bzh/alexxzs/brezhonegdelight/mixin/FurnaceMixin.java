package bzh.alexxzs.brezhonegdelight.mixin;

import bzh.alexxzs.brezhonegdelight.BrezhonegDelight;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFurnaceBlockEntity.class)
public class FurnaceMixin {


    @Inject(method = "craftRecipe", at = @At("RETURN"))
    private static void keepBucket(DynamicRegistryManager registryManager, RecipeEntry<SmeltingRecipe> recipe, DefaultedList<ItemStack> slots, int count, CallbackInfoReturnable<Boolean> cir) {

        if (recipe.id().getNamespace().equals(BrezhonegDelight.MOD_ID)) {
            //if (slots.get(0).getItem() == Items.WATER_BUCKET) {
                slots.set(0, new ItemStack(Items.BUCKET));

            //}
        }
    }
}
