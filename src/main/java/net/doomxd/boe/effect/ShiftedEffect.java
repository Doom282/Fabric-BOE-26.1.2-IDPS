package net.doomxd.boe.effect;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ShiftedEffect extends MobEffect {
    protected ShiftedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    protected ShiftedEffect(MobEffectCategory category, int color, ParticleOptions particleOptions) {
        super(category, color, particleOptions);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        //AABB boundingbox = mob.getBoundingBox().inflate(amplification+1);
        //List<Entity> entities = serverLevel.getEntities(mob, boundingbox);
/**
        for(Entity entity : entities)
        {
            if(entity instanceof LivingEntity livingEntity)
            {
                livingEntity.hurtServer(serverLevel, mob.damageSources().magic(), 0.25f*(amplification+1));
            }
        }
 **/
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }
}
