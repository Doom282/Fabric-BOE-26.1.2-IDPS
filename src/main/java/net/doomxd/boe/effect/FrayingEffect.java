package net.doomxd.boe.effect;

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
            serverLevel.playSound(null, mob.blockPosition(), SoundEvents.ANVIL_PLACE, SoundSource.PLAYERS);
            tock = 20;
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
            lvl.playSound(null, entity.blockPosition(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS);
        }
        super.onEffectRemoved(effectInstance, entity);
    }
}
