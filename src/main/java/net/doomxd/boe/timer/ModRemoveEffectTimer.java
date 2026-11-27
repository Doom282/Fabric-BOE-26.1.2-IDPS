package net.doomxd.boe.timer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class ModRemoveEffectTimer implements ServerTickEvents.EndTick {
    public static final ModRemoveEffectTimer INSTANCE = new ModRemoveEffectTimer();
    private long ticksUntilSomething;
    private MobEffectInstance effectInstance;
    private LivingEntity player;
    private String action;


    public void removeEffectTimer(long ticksUntilSomething, MobEffectInstance effectInstance, LivingEntity player) {
        this.ticksUntilSomething = ticksUntilSomething;
        this.effectInstance = effectInstance;
        this.player = player;
    }

    @Override
    public void onEndTick(MinecraftServer server) {
        if (--this.ticksUntilSomething == 0L) {
            if(effectInstance!=null && player != null )
            {
                player.removeEffect(effectInstance.getEffect());
            }
            // If you want to repeat this, reset ticksUntilSomething here.
        }
    }
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(INSTANCE);
    }
}
