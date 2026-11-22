package net.doomxd.boe.networking;

import net.doomxd.boe.effect.ModEffects;
import net.doomxd.boe.item.ModItems;
import net.doomxd.boe.networking.packet.LensFuelPayloadC2S;
import net.doomxd.boe.utility.ModUtilityMethods;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.Objects;

//THIS IS ON THE SERVER
public class ServerboundPackets {


    public static void handleLensFuelPayload(LensFuelPayloadC2S lensFuelPayloadC2S, ServerPlayNetworking.Context context) {
        boolean paidXp = false;
        if(!context.player().hasEffect(ModEffects.OPENED_EYES) && !context.player().hasEffect(ModEffects.SHIFTED)) {
            if(context.player().isCreative() || (context.player().hasEffect(MobEffects.SLOWNESS) && Objects.requireNonNull(context.player().getEffect(MobEffects.SLOWNESS)).getAmplifier()==0))
            {
                ModUtilityMethods.fade(context.player());
                context.player().removeEffect(MobEffects.SLOWNESS);
            }
            else if(context.player().getMainHandItem().is(ModItems.LESOLITE))
            {
                context.player().getMainHandItem().setCount(context.player().getMainHandItem().count()-1);
                context.player().level().playSound(null, context.player().getX(), context.player().getY(), context.player().getZ(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS);

                ModUtilityMethods.fade(context.player());
            }
            else if(context.player().experienceLevel>=1)
            {
                context.player().giveExperiencePoints(-60);
                ModUtilityMethods.fadeSickly(context.player());
                context.player().level().playSound(null, context.player().getX(), context.player().getY(), context.player().getZ(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1f, -100f);

            }

        }
        else if(context.player().hasEffect(ModEffects.OPENED_EYES)) {
            if(context.player().hasEffect(MobEffects.NAUSEA)&& Objects.requireNonNull(context.player().getEffect(MobEffects.NAUSEA)).getAmplifier() ==0)
            {
                context.player().giveExperiencePoints(60);
                context.player().removeEffect(MobEffects.NAUSEA);
            }
            ModUtilityMethods.fadeOut(context.player());
        }
    }
}
