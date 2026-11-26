package net.doomxd.boe.effect;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class FunctionlessEffect extends MobEffect {
    protected FunctionlessEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    protected FunctionlessEffect(MobEffectCategory category, int color, ParticleOptions particleOptions) {
        super(category, color, particleOptions);
    }
}
