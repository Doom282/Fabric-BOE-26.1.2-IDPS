package net.doomxd.boe.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.doomxd.boe.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin extends Entity{

    @Shadow
    public abstract boolean hasEffect(Holder<MobEffect> effect);

    @Shadow
    public abstract boolean addEffect(MobEffectInstance newEffect);

    public LivingEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }


    @ModifyReturnValue(method = "hasLineOfSight(Lnet/minecraft/world/entity/Entity;)Z", at = @At("RETURN"))
    public boolean hasLineOfSight(boolean original, Entity target) {
        if(target instanceof LivingEntity targetEntity) {
            return original && targetEntity.hasEffect(ModEffects.SHIFTED) == this.hasEffect(ModEffects.SHIFTED);
        }

        return original;
    }

/**
    @Inject(method = "removeAllEffects", at=@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;onEffectsRemoved(Ljava/util/Collection;)V"))
    public void removeAllEffects(CallbackInfoReturnable<Boolean> cir, @Local(name = "copy") Map<Holder<MobEffect>, MobEffectInstance> copy)
    {
        if(copy.containsValue(ModEffects.SHIFTED)) {
            this.addEffect(new MobEffectInstance(ModEffects.SHIFTED, -1, 0, false, true));
        }
    }




     @Inject(method = "updateInvisibilityStatus", at = @At("TAIL"))
     public void updateInvisibilityStatus(CallbackInfo ci){
     assert Minecraft.getInstance().player != null;
     if(this.hasEffect(ModEffects.SHIFTED) != Minecraft.getInstance().player.hasEffect(ModEffects.SHIFTED))
     {
     this.setInvisible(true);
     }
     }
     **/
/**
 *
 * @ModifyExpressionValue(method = "updateInvisibilityStatus", at = @At(value = "FIELD", target = ""))
 *     public Holder<MobEffect> updateInvisibilityStatus(Holder<MobEffect> original) {
 *
 *         return original || this.hasEffect(ModEffects.SHIFTED);
 *     }
      @Inject(method = "getVisibilityPercent", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isDiscrete()Z"))
      public void getVisibilityPercent(Entity targetingEntity, CallbackInfoReturnable<Double> cir, @Local(name = "visibilityPercent") double visibilityPercent) {
      {
      if(this.hasEffect(ModEffects.SHIFTED))
      {
        visibilityPercent = 0;
      }
      }
      }


        @ModifyReturnValue(method = "getVisibilityPercent", at = @At(value = "RETURN"))
    public double getVisibilityPercent(double original) {
            boolean isShifted = this.hasEffect(ModEffects.SHIFTED);
            if(isShifted) {
                return -1;
            }
            return original;
        }
 **/
    /**
    @ModifyReturnValue(method = "canBeSeenByAnyone", at = @At(value = "RETURN"))
    public boolean canBeSeenByAnyone(boolean original){
        return !this.isSpectator() && this.isAlive() && !this.hasEffect(ModEffects.SHIFTED);
    }


    @ModifyReturnValue(method = "canAttack", at = @At(value = "RETURN"))
    public boolean canAttack(boolean original, LivingEntity target)
    {
        boolean isSameShift = (this.hasEffect(ModEffects.SHIFTED) && target.hasEffect(ModEffects.SHIFTED)) || (!this.hasEffect(ModEffects.SHIFTED) && !target.hasEffect(ModEffects.SHIFTED));
        return target instanceof Player && isSameShift && this.level().getDifficulty() == Difficulty.PEACEFUL ? false : target.canBeSeenAsEnemy();
    }
     **/
}