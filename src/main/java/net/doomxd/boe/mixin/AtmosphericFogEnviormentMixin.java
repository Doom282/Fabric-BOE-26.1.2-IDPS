package net.doomxd.boe.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.doomxd.boe.attachment.ModAttachments;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.environment.AtmosphericFogEnvironment;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AtmosphericFogEnvironment.class)
abstract class AtmosphericFogEnviormentMixin {
    @ModifyReturnValue(method = "getBaseColor", at = @At(value = "RETURN"))
    public int getBaseColor(int original, ClientLevel level, Camera camera, int renderDistance, float partialTicks)
    {
        if(camera.entity() instanceof LivingEntity livingEntity) {
            if(livingEntity.hasAttached(ModAttachments.IS_SHIFTED))
                if(Boolean.TRUE.equals(livingEntity.getAttached(ModAttachments.IS_SHIFTED)))
                {
                    return -47872;
                }
        }
        return original;
    }
}
