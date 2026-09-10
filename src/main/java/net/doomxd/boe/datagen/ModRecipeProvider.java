package net.doomxd.boe.datagen;

import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output)
        {
            @Override
            public void buildRecipes()
            {
                List<ItemLike> BOE_LESOLITE_ITEMS = List.of(ModItems.LESOLITE_POOR_LENS, ModItems.LESOLITE, ModBlocks.LESOLITE_ORE);

                oreSmelting(BOE_LESOLITE_ITEMS, RecipeCategory.MISC, CookingBookCategory.BLOCKS,
                        ModItems.LESOLITE, 4.0f, 200, "lesolite");
                oreBlasting(BOE_LESOLITE_ITEMS, RecipeCategory.MISC, CookingBookCategory.BLOCKS,
                        ModItems.LESOLITE, 8.0f, 100, "lesolite");

                shaped(RecipeCategory.MISC, ModItems.LESOLITE_POOR_LENS)
                        .pattern("RLR")
                        .pattern("LLL")
                        .pattern("RLR")
                        .define('R', Items.BLAZE_ROD )
                        .define('L', ModItems.LESOLITE)
                        .unlockedBy(getHasName(ModItems.LESOLITE), has(ModItems.LESOLITE))
                        .group("lesolite")
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "BOE Recipes";
    }
}
