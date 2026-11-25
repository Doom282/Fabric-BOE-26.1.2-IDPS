package net.doomxd.boe.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.blaze3d.vertex.PoseStack;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntityRenderer.class)
abstract class LivingEntityRendererMixin <T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> extends EntityRenderer<T, S> implements RenderLayerParent<S, M> {

    protected LivingEntityRendererMixin(EntityRendererProvider.Context context) {
        super(context);

    }

/**
    @ModifyReturnValue(method = "isBodyVisible", at = @At(value = "RETURN"))
    public boolean isBodyVisible(boolean flag, LivingEntityRenderState livingEntityRenderState) {
       return false;
    }

    @ModifyExpressionValue(method="extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;isInvisible:Z"))
    public boolean extractRenderState(boolean original, LivingEntity entity, LivingEntityRenderState state) {
        boolean isInvisTo = entity.isInvisibleTo(Minecraft.getInstance().player);
        return original || isInvisTo;
    }


     @ModifyReturnValue(method = "isBodyVisible", at = @At(value = "RETURN"))
     public boolean isBodyVisible(boolean original, LivingEntityRenderState state) {
     return !state.isInvisibleToPlayer;
     }


    @ModifyExpressionValue(method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V", @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isInvisibleTo(Lnet/minecraft/world/entity/player/Player;)Z"))
    public void extractRenderState(T entity, S state, float partialTicks, CallbackInfo ci) {
        Player player = Minecraft.getInstance().player;
        boolean norm = state.isInvisible && entity.isInvisibleTo(Minecraft.getInstance().player != null ? Minecraft.getInstance().player : null);
        if (entity instanceof LivingEntity livingEntity && player != null) {
            if(norm || livingEntity.hasEffect(ModEffects.SHIFTED) != player.hasEffect(ModEffects.SHIFTED)) {
                state.isInvisibleToPlayer = true;
            }
            else  {
                state.isInvisibleToPlayer = false;
            }

        }
        else
        {
            state.isInvisibleToPlayer = false;
        }
    }
     **/
}