package net.doomxd.boe.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.doomxd.boe.attachment.ModAttachments;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.client.Minecraft;
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
            if(!livingEntity.hasAttached(ModAttachments.IS_SHIFTED))
            {
                livingEntity.setAttached(ModAttachments.IS_SHIFTED, false);
            }
            if(player.hasAttached(ModAttachments.IS_SHIFTED))
            {
                player.setAttached(ModAttachments.IS_SHIFTED, false);
            }
            if((player.hasEffect(ModEffects.SHIFTED) != livingEntity.getAttached(ModAttachments.IS_SHIFTED)) && livingEntity.getAttached(ModAttachments.IS_SHIFTED) && !player.hasEffect(ModEffects.OPENED_EYES))
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