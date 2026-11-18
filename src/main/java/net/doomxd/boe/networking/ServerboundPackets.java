package net.doomxd.boe.networking;

import net.doomxd.boe.effect.ModEffects;
import net.doomxd.boe.item.ModItems;
import net.doomxd.boe.networking.packet.LensFuelPayloadC2S;
import net.doomxd.boe.utility.ModUtilityMethods;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

//THIS IS ON THE SERVER
public class ServerboundPackets {


    public static void handleLensFuelPayload(LensFuelPayloadC2S lensFuelPayloadC2S, ServerPlayNetworking.Context context) {

        if(!context.player().hasEffect(ModEffects.OPENED_EYES) && !context.player().hasEffect(ModEffects.SHIFTED)) {
            if(context.player().isCreative())
            {
                ModUtilityMethods.fade(context.player());

            }
            else if(context.player().getMainHandItem().is(ModItems.LESOLITE))
            {
                context.player().getMainHandItem().setCount(context.player().getMainHandItem().count()-1);
                context.player().level().playSound(null, context.player().getX(), context.player().getY(), context.player().getZ(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS);

                ModUtilityMethods.fade(context.player());
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
                    ModUtilityMethods.fade(context.player());
                    context.player().level().playSound(null, context.player().getX(), context.player().getY(), context.player().getZ(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1f, -100f);

            }
            else if(context.player().experienceLevel>=1)
            {
                context.player().setExperienceLevels(context.player().experienceLevel-1);
                ModUtilityMethods.fade(context.player());
                context.player().level().playSound(null, context.player().getX(), context.player().getY(), context.player().getZ(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1f, -100f);

            }

        }
        else if(context.player().hasEffect(ModEffects.OPENED_EYES)) {
            ModUtilityMethods.fadeOut(context.player());
        }
    }
}
