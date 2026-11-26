package net.doomxd.boe.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.doomxd.boe.attachment.ModAttachments;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
abstract class PlayerMixin extends Avatar {

    protected PlayerMixin(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    @ModifyReturnValue(method = "cannotAttack", at = @At("RETURN"))
    public boolean cannotAttack(boolean original, Entity entity)
    {
        if(entity instanceof LivingEntity entity1) {
            if (!entity1.hasAttached(ModAttachments.IS_SHIFTED)) {
                entity1.setAttached(ModAttachments.IS_SHIFTED, false);
            }
            if(!this.hasAttached(ModAttachments.IS_SHIFTED))
            {
                this.setAttached(ModAttachments.IS_SHIFTED, false);
            }
            boolean entityShifted = Boolean.TRUE.equals(entity1.getAttached(ModAttachments.IS_SHIFTED));
            boolean playerShifted = this.hasEffect(ModEffects.SHIFTED);
            boolean sameShift = entityShifted == playerShifted;
            if(!sameShift) {
                return true;
            }
        }
        return original;
    }
}
