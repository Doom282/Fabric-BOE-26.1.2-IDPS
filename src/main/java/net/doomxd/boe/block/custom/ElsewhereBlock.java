package net.doomxd.boe.block.custom;

import com.mojang.serialization.MapCodec;
import net.doomxd.boe.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ElsewhereBlock extends BaseEntityBlock {

    public ElsewhereBlock(Properties properties) {
        super(properties);
    }

    protected boolean propagatesSkylightDown(final BlockState state) {
        return state.getFluidState().isEmpty();
    }

    protected RenderShape getRenderShape(final BlockState state) {
        return RenderShape.INVISIBLE;
    }

    protected float getShadeBrightness(final BlockState state, final BlockGetter level, final BlockPos pos) {
        return 1.0F;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if(!(context instanceof EntityCollisionContext entityCollisionContext))
        {
            return Shapes.empty();
        }
        else {
            if(entityCollisionContext.getEntity() !=null && entityCollisionContext.getEntity().is(EntityType.PLAYER))
            {
                Entity player = entityCollisionContext.getEntity();
                if(player.isCrouching())
                {
                    return Shapes.block();
                }
                else
                {
                    return Shapes.empty();
                }
            }
            return Shapes.block();
        }
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(ElsewhereBlock::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return ModBlockEntities.ELSEWORLD_BLOCK_ENTITY_BLOCK_ENTITY_TYPE.create(worldPosition, blockState);
    }
}
