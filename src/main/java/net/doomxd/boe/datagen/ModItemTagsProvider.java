package net.doomxd.boe.datagen;

import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, @Nullable BlockTagsProvider blockTagsProvider) {
        super(output, registryLookupFuture, blockTagsProvider);
    }

    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        //valueLookupBuilder(ModTags.Items.dfdsdfsfdfds).add(ModItems.LESOLITE).add(Items.ACACIA_BOAT);
        tag(ItemTags.SAPLINGS)
                .add(ModItems.getRK(ModBlocks.ELSEWHERE_WOOD_SAPLING.asItem()));

        tag(ItemTags.PLANKS)
                .add(ModItems.getRK(ModBlocks.ELSEWHERE_WOOD_PLANKS.asItem()));

        tag(ItemTags.LEAVES)
                .add(ModItems.getRK(ModBlocks.ELSEWHERE_LEAVES.asItem()));

    }
}
