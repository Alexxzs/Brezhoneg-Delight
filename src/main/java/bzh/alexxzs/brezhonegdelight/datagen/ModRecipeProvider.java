package bzh.alexxzs.brezhonegdelight.datagen;

import bzh.alexxzs.brezhonegdelight.BrezhonegDelight;
import bzh.alexxzs.brezhonegdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        offerSmelting(recipeExporter, Collections.singletonList(Items.WATER_BUCKET), RecipeCategory.FOOD, ModItems.SALT, 0.5f, 200, "salt");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SEMI_SALTED_BUTTER)
                .input(ModItems.SALT)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(ModItems.SALT), conditionsFromItem(ModItems.SALT))
                .offerTo(recipeExporter, Identifier.of(BrezhonegDelight.MOD_ID, "semi_salted_butter"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.KOUIGN_AMANN)
                .pattern("BBB")
                .pattern("SSS")
                .pattern("WWW")
                .input('B', ModItems.SEMI_SALTED_BUTTER)
                .input('S', Items.SUGAR)
                .input('W', Items.WHEAT)
                .criterion(hasItem(ModItems.SEMI_SALTED_BUTTER), conditionsFromItem(ModItems.SEMI_SALTED_BUTTER))
                .offerTo(recipeExporter, Identifier.of(BrezhonegDelight.MOD_ID, "kouign_amann"));



    }
}
