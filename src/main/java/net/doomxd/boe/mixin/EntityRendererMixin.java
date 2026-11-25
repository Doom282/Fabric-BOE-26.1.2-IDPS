package net.doomxd.boe.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.doomxd.boe.attachment.ModAttachments;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EntityRenderer.class)
abstract class EntityRendererMixin <T extends Entity, S extends EntityRenderState>{

    @ModifyExpressionValue(method = "extractRenderState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isInvisible()Z"))
    private boolean isInvisible(boolean original, Entity entity) {
        if(entity instanceof LivingEntity entity1) {
            if(Minecraft.getInstance().player != null) {
                boolean entityShifted = Boolean.TRUE.equals(entity1.getAttached(ModAttachments.IS_SHIFTED));
                boolean playerShifted =   Minecraft.getInstance().player.hasEffect(ModEffects.SHIFTED);
                boolean sameShift = entityShifted == playerShifted;
                if(!sameShift) {
                    return true;
                }
            }
        }
        return original;
    }
}
