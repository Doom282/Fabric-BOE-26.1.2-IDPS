package net.doomxd.boe.networking;

import net.doomxd.boe.effect.ModEffects;
import net.doomxd.boe.item.ModItems;
import net.doomxd.boe.networking.packet.LensFuelPayloadC2S;
import net.doomxd.boe.timer.ModFunctionTimer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;

//THIS IS ON THE SERVER
public class ServerboundPackets {
    public static void handleLensFuelPayload(LensFuelPayloadC2S lensFuelPayloadC2S, ServerPlayNetworking.Context context) {

        net.minecraft.world.effect.MobEffectInstance woozy = new MobEffectInstance(MobEffects.DARKNESS, 60, 12, false, false);
        net.minecraft.world.effect.MobEffectInstance blind = new MobEffectInstance(MobEffects.BLINDNESS, 10, 20, false, false);

        net.minecraft.world.effect.MobEffectInstance see = new MobEffectInstance(ModEffects.OPENED_EYES, 3600, 0, true, true);
        if(!context.player().hasEffect(ModEffects.OPENED_EYES) && !context.player().hasEffect(ModEffects.SHIFTED)) {
            if(context.player().isCreative())
            {
                context.player().addEffect(woozy);
                ModFunctionTimer.INSTANCE.setEffectTimer(10, blind, context.player());
                ModFunctionTimer.INSTANCE.setEffectTimer(30, see, context.player());

            }
            else if(context.player().getMainHandItem().is(ModItems.LESOLITE))
            {
                context.player().getMainHandItem().setCount(context.player().getMainHandItem().count()-1);
                context.player().level().playSound(null, context.player().getX(), context.player().getY(), context.player().getZ(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS);

                context.player().addEffect(woozy);
                context.player().addEffect(blind);
                ModFunctionTimer.INSTANCE.setEffectTimer(30, see, context.player());
            }
            else if(context.player().experienceLevel>15)
            {
                    int currentXpPoints = (int) (context.player().getXpNeededForNextLevel()*context.player().experienceProgress);
                    if(context.player().experienceProgress>0.5f)
                    {
                        int halfsies =  (int) (context.player().getXpNeededForNextLevel()*0.5f);
                        context.player().setExperiencePoints(currentXpPoints-halfsies);
                    }
                    else {
                        context.player().setExperienceLevels(context.player().experienceLevel-1);
                        int halfsies =  (int) (context.player().getXpNeededForNextLevel()*0.5f);
                        context.player().setExperiencePoints(halfsies+currentXpPoints);
                    }
                context.player().addEffect(woozy);
                context.player().addEffect(blind);
                ModFunctionTimer.INSTANCE.setEffectTimer(30, see, context.player());
            }
            else if(context.player().experienceLevel>=1)
            {
                context.player().setExperienceLevels(context.player().experienceLevel-1);
                context.player().addEffect(woozy);
                context.player().addEffect(blind);
                ModFunctionTimer.INSTANCE.setEffectTimer(30, see, context.player());
            }

        }
        else if(context.player().hasEffect(ModEffects.OPENED_EYES)) {
            context.player().removeEffect(ModEffects.OPENED_EYES);
        }
    }
}
