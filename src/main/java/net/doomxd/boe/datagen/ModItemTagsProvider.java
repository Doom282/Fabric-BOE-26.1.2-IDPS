package net.doomxd.boe.datagen;

import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.item.ModItems;
import net.doomxd.boe.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
        valueLookupBuilder(ModTags.Items.ELSEWHERE_WOOD_BLOCKS).add(ModBlocks.ELSEWHERE_WOOD.asItem());
        valueLookupBuilder(ItemTags.LOGS).add(ModBlocks.ELSEWHERE_WOOD.asItem());
        valueLookupBuilder(ItemTags.LEAVES).add(ModBlocks.ELSEWHERE_LEAVES.asItem());
        valueLookupBuilder(ItemTags.SAPLINGS).add(ModBlocks.ELSEWHERE_WOOD_SAPLING.asItem());
        //valueLookupBuilder(ModTags.Items.dfdsdfsfdfds).add(ModItems.LESOLITE).add(Items.ACACIA_BOAT);

    }
}
