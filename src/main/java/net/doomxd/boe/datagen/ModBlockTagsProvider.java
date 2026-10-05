package net.doomxd.boe.datagen;

import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider{

    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFeature){
        super(output, registryLookupFeature);
    }
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LESOLITE_ORE);
        valueLookupBuilder(BlockTags.LOGS).add(ModBlocks.ELSEWHERE_WOOD);
        valueLookupBuilder(BlockTags.PLANKS).add(ModBlocks.ELSEWHERE_WOOD_PLANKS);
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN).add(ModBlocks.ELSEWHERE_WOOD);
        valueLookupBuilder(BlockTags.LEAVES).add(ModBlocks.ELSEWHERE_LEAVES);
    }
}
