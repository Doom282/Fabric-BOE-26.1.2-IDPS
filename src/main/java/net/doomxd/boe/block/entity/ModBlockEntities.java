package net.doomxd.boe.block.entity;

import net.doomxd.boe.BeyondOnesEyes;
import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.block.custom.ElsewhereRotatedPillarBlock;
import net.doomxd.boe.block.entity.custom.ElsewhereBlockEntity;
import net.doomxd.boe.block.entity.custom.ElsewhereRotatedPillarBlockEntity;
import net.doomxd.boe.block.entity.custom.InvertedElsewhereBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
     public static final BlockEntityType<ElsewhereBlockEntity> ELSEWORLD_BLOCK_ENTITY_BLOCK_ENTITY_TYPE =
             Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                     Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID,
                             "elseworld_be"), FabricBlockEntityTypeBuilder
                             .create(ElsewhereBlockEntity::new,
                                     ModBlocks.ELSEWHERE_WOOD_PLANKS,
                                     ModBlocks.ELSEWHERE_WOOD,
                                     ModBlocks.ELSEWHERE_LEAVES,
                                     ModBlocks.FRAYGLASS_LEAVES,
                                     ModBlocks.FRAYGLASS_WILLOW_WOOD,
                                     ModBlocks.FRAYGLASS_WILLOW_LOG,
                                     ModBlocks.FRAYGLASS_WILLOW_PLANKS,
                                     ModBlocks.GILDED_FRAYGLASS_WILLOW_LOG,
                                     ModBlocks.GILDED_FRAYGLASS_WILLOW_WOOD
                             //list all blocks for elsewhere blocks here



                             ).build());

    public static final BlockEntityType<ElsewhereRotatedPillarBlockEntity> ELSEWORLD_ROTATED_PILLAR_BLOCK_ENTITY_BLOCK_ENTITY_TYPE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID,
                            "elseworld_rotated_pillar_be"), FabricBlockEntityTypeBuilder
                            .create(ElsewhereRotatedPillarBlockEntity::new,
                                    ModBlocks.FRAYGLASS_WILLOW_LOG,
                                    ModBlocks.GILDED_FRAYGLASS_WILLOW_LOG
                                    //list all blocks for elsewhere blocks here



                            ).build());


    public static final BlockEntityType<InvertedElsewhereBlockEntity> INVERTED_ELSEWORLD_BLOCK_ENTITY_BLOCK_ENTITY_TYPE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID,
                            "inverse_elseworld_be"), FabricBlockEntityTypeBuilder
                            .create(InvertedElsewhereBlockEntity::new, ModBlocks.ELSEWHERE_BARRIER
                                    //list all blocks for elsewhere blocks here



                            ).build());
    public static void registerBlockEntities()
    {
        BeyondOnesEyes.LOGGER.info("Registering Block Entities for" + BeyondOnesEyes.MOD_ID);
    }
}
