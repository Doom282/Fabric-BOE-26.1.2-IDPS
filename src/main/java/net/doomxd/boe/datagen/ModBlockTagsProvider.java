package net.doomxd.boe.datagen;

import net.doomxd.boe.block.ModBlocks;
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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.LESOLITE_ORE));
        tag(BlockTags.LOGS).add(ModBlocks.getRK(ModBlocks.ELSEWHERE_WOOD));
        tag(BlockTags.PLANKS).add(ModBlocks.getRK(ModBlocks.ELSEWHERE_WOOD_PLANKS));
        tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(ModBlocks.getRK(ModBlocks.ELSEWHERE_WOOD));
        tag(BlockTags.LEAVES).add(ModBlocks.getRK(ModBlocks.ELSEWHERE_LEAVES));
        tag(BlockTags.FLOWER_POTS).add(ModBlocks.getRK(ModBlocks.POTTED_ELSEWHERE_WOOD_SAPLING));
    }
}
