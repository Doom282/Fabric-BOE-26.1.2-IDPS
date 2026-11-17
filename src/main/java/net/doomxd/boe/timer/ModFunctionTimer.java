package net.doomxd.boe.timer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;

public class ModFunctionTimer implements ServerTickEvents.EndTick {
    public static final ModFunctionTimer INSTANCE = new ModFunctionTimer();
    private long ticksUntilSomething;
    private MobEffectInstance effectInstance;
    private ServerPlayer player;


    public void setEffectTimer(long ticksUntilSomething, MobEffectInstance effectInstance, ServerPlayer player) {
        this.ticksUntilSomething = ticksUntilSomething;
        this.effectInstance = effectInstance;
        this.player = player;

    }

    @Override
    public void onEndTick(MinecraftServer server) {
        if (--this.ticksUntilSomething == 0L) {
            if(effectInstance!=null && player != null)
            {
                player.addEffect(effectInstance);
            }
            // If you want to repeat this, reset ticksUntilSomething here.
        }
    }
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(INSTANCE);
    }
}
