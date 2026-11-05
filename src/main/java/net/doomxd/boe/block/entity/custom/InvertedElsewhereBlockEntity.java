package net.doomxd.boe.block.entity.custom;

import net.doomxd.boe.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class InvertedElsewhereBlockEntity extends BlockEntity  {
     public InvertedElsewhereBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(ModBlockEntities.INVERTED_ELSEWORLD_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, worldPosition, blockState);
    }
}
