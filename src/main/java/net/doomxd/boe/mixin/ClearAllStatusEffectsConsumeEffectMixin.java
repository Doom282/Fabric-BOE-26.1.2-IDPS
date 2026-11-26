package net.doomxd.boe.mixin;

import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClearAllStatusEffectsConsumeEffect.class)
abstract class ClearAllStatusEffectsConsumeEffectMixin implements ConsumeEffect {
/**
    @ModifyReturnValue(method = "apply", at= @At(value = "RETURN"))
    private boolean apply(boolean original, final Level level, final ItemStack stack, final LivingEntity user) {
        if(user instanceof ServerPlayer player)
        {
            player.giveExperiencePoints(90);
            return false;
        }
        return original;
    }
    **/
}
