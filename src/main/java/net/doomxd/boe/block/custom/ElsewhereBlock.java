package net.doomxd.boe.block.custom;

import com.mojang.serialization.MapCodec;
import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.block.entity.ModBlockEntities;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class ElsewhereBlock extends BaseEntityBlock {
    private final IntProvider xpRange = UniformInt.of(0, 2);
    public static final BooleanProperty BREAKING = BooleanProperty.create("breaking");

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BREAKING);
    }

    public ElsewhereBlock(Properties properties) {
        super(properties);

        registerDefaultState(defaultBlockState().setValue(BREAKING, false));
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
            if(entityCollisionContext.getEntity() !=null)
            {
                Entity goober = entityCollisionContext.getEntity();
                if(goober.asLivingEntity()!= null && goober.asLivingEntity().hasEffect(ModEffects.OPENED_EYES))
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
    protected VoxelShape getOcclusionShape(BlockState state) {
        return Shapes.empty();
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if(!(context instanceof EntityCollisionContext entityCollisionContext))
        {
            return Shapes.empty();
        }
        else {
            if(entityCollisionContext.getEntity() !=null)
            {
                Entity goober = entityCollisionContext.getEntity();
                if(goober.asLivingEntity()!= null && goober.asLivingEntity().hasEffect(ModEffects.OPENED_EYES))
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
    protected void spawnDestroyParticles(Level level, Player player, BlockPos pos, BlockState state) {
        this.poof(level, pos);
        super.spawnDestroyParticles(level, player, pos, state);
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult blockHit, Projectile projectile) {
        BlockPos pos = projectile.getOnPos();
        this.poof(level, pos);
        super.onProjectileHit(level, state, blockHit, projectile);
    }

    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        this.smolpoof(player.level(), pos);
        return super.getDestroyProgress(state, player, level, pos);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        this.poof(level, pos);
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

    public void poof(Level level, BlockPos pos)
    {
        for (int i = 0; i < 8; i++) {
            level.addParticle(ParticleTypes.END_ROD,
                    pos.getX()+Math.random(),
                    pos.getY()+Math.random(),
                    pos.getZ()+Math.random(),

                    Math.random() - 0.5,
                    Math.random() - 0.5,
                    Math.random() - 0.5);
        }
    }

    public void smolpoof(Level level, BlockPos pos)
    {
            level.addParticle(ParticleTypes.END_ROD,
                    pos.getX()+Math.random(),
                    pos.getY()+Math.random(),
                    pos.getZ()+Math.random(),

                    Math.random() - 0.5,
                    Math.random() - 0.5,
                    Math.random() - 0.5);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return (Boolean)state.getValue(BREAKING);
    }
/**
    protected void randomTick(final BlockState state, final ServerLevel level, final BlockPos pos, final RandomSource random) {
        if ((Boolean)state.getValue(BREAKING)) {
            this.poof(level, pos);
            level.setBlock(pos, (BlockState)state.setValue(BREAKING, false), 3);
        }

    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if ((Boolean)state.getValue(BREAKING)) {
            this.poof(level, pos);
        }
        super.animateTick(state, level, pos, random);
    }

**/
    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        this.poof(level, pos);
        state.setValue(BREAKING, true);
        return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected void attack(BlockState state, Level level, BlockPos pos, Player player) {
        this.poof(level, pos);
        state.setValue(BREAKING, true);
        super.attack(state, level, pos, player);
    }


    protected void spawnAfterBreak(final BlockState state, final ServerLevel level, final BlockPos pos, final ItemStack tool, final boolean dropExperience) {
        super.spawnAfterBreak(state, level, pos, tool, dropExperience);
        if (dropExperience && state.equals(ModBlocks.ELSEWHERE_LEAVES.defaultBlockState())) {
            this.tryDropExperience(level, pos, tool, this.xpRange);
        }

    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return false;
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
