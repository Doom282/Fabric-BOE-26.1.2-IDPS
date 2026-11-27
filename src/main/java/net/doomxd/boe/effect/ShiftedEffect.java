package net.doomxd.boe.effect;

import net.doomxd.boe.attachment.ModAttachments;
import net.doomxd.boe.timer.ModAddEffectTimer;
import net.doomxd.boe.utility.ModUtilityMethods;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Delayed;

public class ShiftedEffect extends MobEffect {
    public int delay;
    protected ShiftedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    protected ShiftedEffect(MobEffectCategory category, int color, ParticleOptions particleOptions) {
        delay=40;
        super(category, color, particleOptions);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        mob.setAttached(ModAttachments.IS_SHIFTED, true);
        if(mob instanceof ServerPlayer player)
        {
            if(player.experienceLevel >0)
            {
                if(delay == 20)
                {
                    player.giveExperiencePoints(-1);
                    delay=0;
                }
                else
                {
                    delay+=1;
                }
                /**
                int currentXpPoints = (int) (player.getXpNeededForNextLevel()*player.experienceProgress);
                if(player.experienceProgress>0.5f)
                {
                    int halfsies =  (int) (player.getXpNeededForNextLevel()*0.5f);
                    player.setExperiencePoints(currentXpPoints-halfsies);
                }
                else {
                    player.setExperienceLevels(player.experienceLevel-1);
                    int halfsies =  (int) (player.getXpNeededForNextLevel()*0.5f);
                    player.setExperiencePoints(halfsies+currentXpPoints);
                }
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1f, -100f);
                 **/

            }
            else
            {
                player.hurtServer(serverLevel, mob.damageSources().wither(), 3.5f);
            }
        }
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void onEffectRemoved(MobEffectInstance effectInstance, LivingEntity entity) {
        if(!entity.hasEffect(MobEffects.DARKNESS))
        {
            if(entity instanceof ServerPlayer player)
            {
                if(!player.gameMode.isCreative() && (Objects.requireNonNull(player.getEffect(ModEffects.SHIFTED)).getAmplifier() == 12))
                {
                    ModAddEffectTimer.INSTANCE.addEffectTimer(30, new MobEffectInstance(ModEffects.SHIFTED, -1, 0, false, true), player);
                    player.giveExperiencePoints(90);
                }
            }
        }
        entity.setAttached(ModAttachments.IS_SHIFTED, false);
        super.onEffectRemoved(effectInstance, entity);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }
}
