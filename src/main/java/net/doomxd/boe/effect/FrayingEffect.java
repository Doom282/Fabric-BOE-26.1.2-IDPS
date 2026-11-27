package net.doomxd.boe.effect;

import net.doomxd.boe.timer.ModAddEffectTimer;
import net.doomxd.boe.utility.ModUtilityMethods;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.Objects;

public class FrayingEffect extends MobEffect {
    private int tock = 0;

    protected FrayingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    protected FrayingEffect(MobEffectCategory category, int color, ParticleOptions particleOptions) {
        super(category, color, particleOptions);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        double dur = mob.getEffect(ModEffects.FRAYING).getDuration();
        if(tock <= 0 && dur <=61)
        {
            tock = 20;
            float one = 0.7F;
            float two = 0.6F;
            float three = 0.5F;
            if (dur > 41) {
                serverLevel.playSound(null, mob.blockPosition(), SoundEvents.ANVIL_PLACE, SoundSource.PLAYERS, 0.5F, one);
            }
            else if(dur >21)
            {
                serverLevel.playSound(null, mob.blockPosition(), SoundEvents.ANVIL_PLACE, SoundSource.PLAYERS, 0.5F, two);
            }
            else if(dur >0)
            {
                serverLevel.playSound(null, mob.blockPosition(), SoundEvents.ANVIL_PLACE, SoundSource.PLAYERS, 0.5F, three);
            }

        }
        else if(Objects.requireNonNull(mob.getEffect(ModEffects.FRAYING)).getDuration()<=61) {
            tock--;
        }
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void onEffectRemoved(MobEffectInstance effectInstance, LivingEntity entity) {
        if(entity.level() instanceof ServerLevel lvl) {
            entity.hurtServer(lvl, entity.damageSources().wither(), effectInstance.getAmplifier());
            lvl.playSound(null, entity.blockPosition(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 0.5F, 1F);
            entity.addEffect(new MobEffectInstance(ModEffects.SHIFTED, 25, 0, false, true));
            ModUtilityMethods.fadeWithout(entity);
        }
        super.onEffectRemoved(effectInstance, entity);
    }
}
