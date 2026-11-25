package net.doomxd.boe.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.doomxd.boe.attachment.ModAttachments;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
abstract class EntityMixin {

    @ModifyReturnValue(method = "isInvisibleTo",at = @At(value = "RETURN"))
    public boolean isInvisibleTo(boolean original, Player player) {
        if((Object) this instanceof LivingEntity livingEntity)
        {
            if((player.hasEffect(ModEffects.SHIFTED) != livingEntity.getAttached(ModAttachments.IS_SHIFTED)) && livingEntity.getAttached(ModAttachments.IS_SHIFTED))
            {
                return true;
            }
        }
        return original;
    }
/**
@ModifyReturnValue(method = "isInvulnerable", at = @At(value = "RETURN"))

    private boolean isInvulnerable(boolean original) {
   if ((Object) this instanceof LivingEntity livingEntity) {
        return original || livingEntity.hasEffect(ModEffects.SHIFTED);
    }
    return original;
}
**/
}