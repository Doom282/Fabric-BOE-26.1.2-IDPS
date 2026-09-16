package net.doomxd.boe.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.block.custom.ElsewhereBlock;
import net.doomxd.boe.block.entity.custom.ElsewhereBlockEntity;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import static java.awt.SystemColor.text;

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
    public void submit(ElseworldBlockEntityRenderState state, PoseStack matrices, SubmitNodeCollector queue, CameraRenderState cameraState) {
        //queue.submitBlockModel(matrices, ModBlocks.ELSEWHERE_BLOCK., 1, 1, 1, 1, 1);

        String text = "boop";
        float width = 0.01f;
        //matrices.pushPose(); CRASHES THE CLIENT, DONT KNOW WHY
        matrices.translate(0.5, 1, 0.5);
        matrices.mulPose(Axis.XP.rotationDegrees(90));
        matrices.scale(1/18f, 1/18f, 1/18f);

// draw the text. params:
// text, x, y, color, ordered text, shadow, text layer type, light, color, background color, outline color
        queue.submitText(
                matrices,
                -width / 2, -1f,
                Component.literal(text).getVisualOrderText(),
                false,
                Font.DisplayMode.SEE_THROUGH,
                state.lightCoords,
                0xffffffff,
                0,
                0
        );

    }
}
