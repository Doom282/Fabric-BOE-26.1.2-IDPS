package net.doomxd.boe.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.doomxd.boe.block.entity.custom.ElsewhereBlockEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class ElsewhereBlockEntityRenderer implements BlockEntityRenderer<ElsewhereBlockEntity, ElseworldBlockEntityRenderState> {

    public ElsewhereBlockEntityRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public ElseworldBlockEntityRenderState createRenderState() {
        return new ElseworldBlockEntityRenderState();
    }

    @Override
    public void extractRenderState(ElsewhereBlockEntity blockEntity,
                                   ElseworldBlockEntityRenderState state, float partialTicks, Vec3 cameraPosition,
                                   ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        state.level = blockEntity.getLevel();
    }

    @Override
    public void submit(ElseworldBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
            
    }
}
