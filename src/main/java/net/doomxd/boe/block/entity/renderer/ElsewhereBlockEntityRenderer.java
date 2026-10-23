package net.doomxd.boe.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.doomxd.boe.block.custom.ElsewhereBlock;
import net.doomxd.boe.block.entity.custom.ElsewhereBlockEntity;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class ElsewhereBlockEntityRenderer implements BlockEntityRenderer<ElsewhereBlockEntity, ElseworldBlockEntityRenderState> {
    public static final BlockDisplayContext BLOCK_DISPLAY_CONTEXT = BlockDisplayContext.create();
    private final BlockEntityRendererProvider.Context context;

    public ElsewhereBlockEntityRenderer(BlockEntityRendererProvider.Context context){
        this.context=context;
    }

    @Override
    public ElseworldBlockEntityRenderState createRenderState() {
        return new ElseworldBlockEntityRenderState();
    }

    @Override
    public void extractRenderState(ElsewhereBlockEntity blockEntity, ElseworldBlockEntityRenderState state, float partialTicks, Vec3 cameraPosition,
                                   ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.level = blockEntity.getLevel();
        context.blockModelResolver().update(state.blockModel, blockEntity.getBlockState(), BLOCK_DISPLAY_CONTEXT);

    }

    @Override
    public void submit(ElseworldBlockEntityRenderState state, PoseStack matrices, SubmitNodeCollector queue, CameraRenderState cameraState) {
        ClientLevel level = Minecraft.getInstance().level;
        assert Minecraft.getInstance().player != null;
        if(Minecraft.getInstance().player.hasEffect(ModEffects.OPENED_EYES)) {

            state.blockModel.submit(matrices, queue, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            //this^ works fine without popPose
            //matrices.pushPose()
            //matrices.popPose();
            //this below acts like i dont have the right parameters and i dunno why
/**
            queue.submitModel(state.blockModel,
                    state,
                    matrices,
                    RenderType.SMALL_BUFFER_SIZE,
                    state.lightCoords,
                    OverlayTexture.NO_OVERLAY,
                    state.breakProgress);

 **/

        /**queue.submitBlockModel(matrices, RenderType.SMALL_BUFFER_SIZE, List.of(state.blockModel.), -1, state.lightCoords, 0,-1);

         **/
            }


/**
        String text = "boop";
        float width = 0.01f;
        //matrices.pushPose(); CRASHES THE CLIENT, DONT KNOW WHY
        matrices.translate(0.5, 1, 0.5);
        matrices.mulPose(Axis.XP.rotationDegrees(90));
        matrices.scale(1/18f, 1/18f, 1/18f);
**/
// draw the text. params:
// text, x, y, color, ordered text, shadow, text layer type, light, color, background color, outline color

        /**
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
         **/

    }
}
