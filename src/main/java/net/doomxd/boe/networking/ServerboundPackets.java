package net.doomxd.boe.networking;

import net.doomxd.boe.effect.ModEffects;
import net.doomxd.boe.networking.packet.LensFuelPayloadC2S;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.world.effect.MobEffectInstance;

//THIS IS ON THE SERVER
public class ServerboundPackets {
    public static void handleLensFuelPayload(LensFuelPayloadC2S lensFuelPayloadC2S, ServerPlayNetworking.Context context) {
        if(!context.player().hasEffect(ModEffects.OPENED_EYES)) {
            net.minecraft.world.effect.MobEffectInstance see = new MobEffectInstance(ModEffects.OPENED_EYES, 3600, 0, true, true);
            context.player().addEffect(see);
        }
        else {
            context.player().removeEffect(ModEffects.OPENED_EYES);
        }
    }
}
