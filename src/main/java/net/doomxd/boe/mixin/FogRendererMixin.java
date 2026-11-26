package net.doomxd.boe.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.doomxd.boe.attachment.ModAttachments;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FogRenderer.class)
abstract class FogRendererMixin {
    @ModifyExpressionValue(method = "computeFogColor", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/fog/environment/FogEnvironment;getBaseColor(Lnet/minecraft/client/multiplayer/ClientLevel;Lnet/minecraft/client/Camera;IF)I"))
    public int computeFogColor(int original, final Camera camera, final float partialTicks, final ClientLevel level, final int renderDistance, final float darkenWorldAmount, final Vector4f dest)
    {

        if(camera.entity() instanceof LivingEntity livingEntity)
        {
            if(livingEntity.hasAttached(ModAttachments.IS_SHIFTED))
            {
                if(livingEntity.hasEffect(ModEffects.SHIFTED))
                {
                  return -47872;
               }
            }
        }
        return original;
    }
}
