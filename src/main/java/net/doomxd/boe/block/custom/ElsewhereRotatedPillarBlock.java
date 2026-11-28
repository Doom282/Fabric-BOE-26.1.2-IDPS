package net.doomxd.boe.block.custom;

import com.mojang.serialization.MapCodec;
import net.doomxd.boe.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jspecify.annotations.Nullable;

public class ElsewhereRotatedPillarBlock extends ElsewhereBlock {

    public static final MapCodec<ElsewhereRotatedPillarBlock> CODEC = simpleCodec(ElsewhereRotatedPillarBlock::new);
    public static final EnumProperty<Direction.Axis> AXIS;



    public ElsewhereRotatedPillarBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState) this.defaultBlockState().setValue(AXIS, Direction.Axis.Y));

    }

    public MapCodec<ElsewhereRotatedPillarBlock> codec() {
        return CODEC;
    }


    protected BlockState rotate(final BlockState state, final Rotation rotation) {
        return rotatePillar(state, rotation);
    }

    public static BlockState rotatePillar(final BlockState state, final Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis)state.getValue(AXIS)) {
                    case X -> {
                        return (BlockState)state.setValue(AXIS, Direction.Axis.Z);
                    }
                    case Z -> {
                        return (BlockState)state.setValue(AXIS, Direction.Axis.X);
                    }
                    default -> {
                        return state;
                    }
                }
            default:
                return state;
        }
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AXIS});
    }


    public BlockState getStateForPlacement(final BlockPlaceContext context) {
        return (BlockState)this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
    }

    static {
        AXIS = BlockStateProperties.AXIS;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return ModBlockEntities.ELSEWORLD_ROTATED_PILLAR_BLOCK_ENTITY_BLOCK_ENTITY_TYPE.create(worldPosition, blockState);
    }
}
