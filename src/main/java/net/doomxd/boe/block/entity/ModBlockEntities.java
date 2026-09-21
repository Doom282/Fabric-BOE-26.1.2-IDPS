package net.doomxd.boe.block.entity;

import net.doomxd.boe.BeyondOnesEyes;
import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.block.entity.custom.ElsewhereBlockEntity;
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
                             .create(ElsewhereBlockEntity::new, ModBlocks.ELSEWHERE_BLOCK).build());
    public static void registerBlockEntities()
    {
        BeyondOnesEyes.LOGGER.info("Registering Block Entities for" + BeyondOnesEyes.MOD_ID);
    }
}
